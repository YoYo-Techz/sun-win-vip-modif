package bitzero.server.controllers.admin.cmd;

import bitzero.server.extensions.data.BaseCmd;
import bitzero.server.extensions.data.DataCmd;

public class LogLevelCmd extends BaseCmd {
     public String logName = "";
     public String level = "";

     public LogLevelCmd(DataCmd dataCmd) {
          super(dataCmd);
     }
}
