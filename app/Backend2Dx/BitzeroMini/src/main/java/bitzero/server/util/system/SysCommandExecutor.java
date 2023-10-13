package bitzero.server.util.system;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SysCommandExecutor {
     private ILogDevice fOuputLogDevice = null;
     private ILogDevice fErrorLogDevice = null;
     private String fWorkingDirectory = null;
     private List fEnvironmentVarList = null;
     private StringBuffer fCmdOutput = null;
     private StringBuffer fCmdError = null;
     private AsyncStreamReader fCmdOutputThread = null;
     private AsyncStreamReader fCmdErrorThread = null;
     private Process process = null;

     public void setOutputLogDevice(ILogDevice logDevice) {
          this.fOuputLogDevice = logDevice;
     }

     public void setErrorLogDevice(ILogDevice logDevice) {
          this.fErrorLogDevice = logDevice;
     }

     public void setWorkingDirectory(String workingDirectory) {
          this.fWorkingDirectory = workingDirectory;
     }

     public void setEnvironmentVar(String name, String value) {
          if (this.fEnvironmentVarList == null) {
               this.fEnvironmentVarList = new ArrayList();
          }

          this.fEnvironmentVarList.add(new EnvironmentVar(name, value));
     }

     public String getCommandOutput() {
          return this.fCmdOutput.toString();
     }

     public String getCommandError() {
          return this.fCmdError.toString();
     }

     public int runCommand(String commandLine) throws Exception {
          this.process = this.runCommandHelper(commandLine);
          this.startOutputAndErrorReadThreads(this.process.getInputStream(), this.process.getErrorStream());
          boolean var2 = true;

          int exitStatus;
          try {
               exitStatus = this.process.waitFor();
          } catch (Throwable var7) {
               throw new Exception(var7.getMessage());
          } finally {
               this.notifyOutputAndErrorReadThreadsToStopReading();
          }

          return exitStatus;
     }

     public void destroy() {
          if (this.process != null) {
               this.process.destroy();
          }

     }

     private Process runCommandHelper(String commandLine) throws Exception {
          Process process = null;
          if (this.fWorkingDirectory == null) {
               process = Runtime.getRuntime().exec(commandLine, this.getEnvTokens());
          } else {
               process = Runtime.getRuntime().exec(commandLine, this.getEnvTokens(), new File(this.fWorkingDirectory));
          }

          return process;
     }

     private void startOutputAndErrorReadThreads(InputStream processOut, InputStream processErr) {
          this.fCmdOutput = new StringBuffer();
          this.fCmdOutputThread = new AsyncStreamReader(processOut, this.fCmdOutput, this.fOuputLogDevice, "OUTPUT");
          this.fCmdOutputThread.start();
          if (this.fErrorLogDevice != null) {
               this.fCmdError = new StringBuffer();
               this.fCmdErrorThread = new AsyncStreamReader(processErr, this.fCmdError, this.fErrorLogDevice, "ERROR");
               this.fCmdErrorThread.start();
          }

     }

     private void notifyOutputAndErrorReadThreadsToStopReading() {
          this.fCmdOutputThread.stopReading();
          this.fCmdErrorThread.stopReading();
     }

     private String[] getEnvTokens() {
          if (this.fEnvironmentVarList == null) {
               return null;
          } else {
               String[] envTokenArray = new String[this.fEnvironmentVarList.size()];
               Iterator envVarIter = this.fEnvironmentVarList.iterator();

               String envVarToken;
               for(int var3 = 0; envVarIter.hasNext(); envTokenArray[var3++] = envVarToken) {
                    EnvironmentVar envVar = (EnvironmentVar)((EnvironmentVar)envVarIter.next());
                    envVarToken = envVar.fName + "=" + envVar.fValue;
               }

               return envTokenArray;
          }
     }
}
