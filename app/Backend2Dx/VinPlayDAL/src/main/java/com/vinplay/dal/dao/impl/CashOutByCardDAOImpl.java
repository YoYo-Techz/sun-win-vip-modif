/*
 * Decompiled with CFR 0.144.
 * 
 * Could not load the following classes:
 *  com.mongodb.BasicDBObject
 *  com.mongodb.Block
 *  com.mongodb.client.FindIterable
 *  com.mongodb.client.MongoCollection
 *  com.mongodb.client.MongoDatabase
 *  com.vinplay.vbee.common.mongodb.MongoDBConnectionFactory
 *  com.vinplay.vbee.common.response.CashOutByCardResponse
 *  com.vinplay.vbee.common.response.MoneyTotalFollowFaceValue
 *  com.vinplay.vbee.common.response.MoneyTotalRechargeByCardReponse
 *  org.bson.Document
 *  org.bson.conversions.Bson
 */
package com.vinplay.dal.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vinplay.dal.dao.CashOutByCardDAO;
import com.vinplay.vbee.common.mongodb.MongoDBConnectionFactory;
import com.vinplay.vbee.common.response.CashOutByCardResponse;
import com.vinplay.vbee.common.response.MoneyTotalFollowFaceValue;
import com.vinplay.vbee.common.response.MoneyTotalRechargeByCardReponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

public class CashOutByCardDAOImpl
implements CashOutByCardDAO {
    private long totalMoney = 0L;
    private long viettelMoney = 0L;
    private long viettel5MMoney = 0L;
    private int viettel5MQuantity = 0;
    private long viettel2MMoney = 0L;
    private int viettel2MQuantity = 0;
    private long viettel1MMoney = 0L;
    private int viettel1MQuantity = 0;
    private long viettel500KMoney = 0L;
    private int viettel500KQuantity = 0;
    private long viettel300KMoney = 0L;
    private int viettel300KQuantity = 0;
    private long viettel200KMoney = 0L;
    private int viettel200KQuantity = 0;
    private long viettel100KMoney = 0L;
    private int viettel100KQuantity = 0;
    private long viettel50KMoney = 0L;
    private int viettel50KQuantity = 0;
    private long viettel30KMoney = 0L;
    private int viettel30KQuantity = 0;
    private long viettel20KMoney = 0L;
    private int viettel20KQuantity = 0;
    private long viettel10KMoney = 0L;
    private int viettel10KQuantity = 0;
    private long vinaphoneMoney = 0L;
    private long vinaphone5MMoney = 0L;
    private int vinaphone5MQuantity = 0;
    private long vinaphone2MMoney = 0L;
    private int vinaphone2MQuantity = 0;
    private long vinaphone1MMoney = 0L;
    private int vinaphone1MQuantity = 0;
    private long vinaphone500KMoney = 0L;
    private int vinaphone500KQuantity = 0;
    private long vinaphone300KMoney = 0L;
    private int vinaphone300KQuantity = 0;
    private long vinaphone200KMoney = 0L;
    private int vinaphone200KQuantity = 0;
    private long vinaphone100KMoney = 0L;
    private int vinaphone100KQuantity = 0;
    private long vinaphone50KMoney = 0L;
    private int vinaphone50KQuantity = 0;
    private long vinaphone30KMoney = 0L;
    private int vinaphone30KQuantity = 0;
    private long vinaphone20KMoney = 0L;
    private int vinaphone20KQuantity = 0;
    private long vinaphone10KMoney = 0L;
    private int vinaphone10KQuantity = 0;
    private long mobifoneMoney = 0L;
    private long mobifone5MMoney = 0L;
    private int mobifone5MQuantity = 0;
    private long mobifone2MMoney = 0L;
    private int mobifone2MQuantity = 0;
    private long mobifone1MMoney = 0L;
    private int mobifone1MQuantity = 0;
    private long mobifone500KMoney = 0L;
    private int mobifone500KQuantity = 0;
    private long mobifone300KMoney = 0L;
    private int mobifone300KQuantity = 0;
    private long mobifone200KMoney = 0L;
    private int mobifone200KQuantity = 0;
    private long mobifone100KMoney = 0L;
    private int mobifone100KQuantity = 0;
    private long mobifone50KMoney = 0L;
    private int mobifone50KQuantity = 0;
    private long mobifone30KMoney = 0L;
    private int mobifone30KQuantity = 0;
    private long mobifone20KMoney = 0L;
    private int mobifone20KQuantity = 0;
    private long mobifone10KMoney = 0L;
    private int mobifone10KQuantity = 0;
    private long vietNamMobileMoney = 0L;
    private long vietNamMobile5MMoney = 0L;
    private int vietNamMobile5MQuantity = 0;
    private long vietNamMobile2MMoney = 0L;
    private int vietNamMobile2MQuantity = 0;
    private long vietNamMobile1MMoney = 0L;
    private int vietNamMobile1MQuantity = 0;
    private long vietNamMobile500KMoney = 0L;
    private int vietNamMobile500KQuantity = 0;
    private long vietNamMobile300KMoney = 0L;
    private int vietNamMobile300KQuantity = 0;
    private long vietNamMobile200KMoney = 0L;
    private int vietNamMobile200KQuantity = 0;
    private long vietNamMobile100KMoney = 0L;
    private int vietNamMobile100KQuantity = 0;
    private long vietNamMobile50KMoney = 0L;
    private int vietNamMobile50KQuantity = 0;
    private long vietNamMobile30KMoney = 0L;
    private int vietNamMobile30KQuantity = 0;
    private long vietNamMobile20KMoney = 0L;
    private int vietNamMobile20KQuantity = 0;
    private long vietNamMobile10KMoney = 0L;
    private int vietNamMobile10KQuantity = 0;
    private long beeLineMoney = 0L;
    private long beeLine5MMoney = 0L;
    private int beeLine5MQuantity = 0;
    private long beeLine2MMoney = 0L;
    private int beeLine2MQuantity = 0;
    private long beeLine1MMoney = 0L;
    private int beeLine1MQuantity = 0;
    private long beeLine500KMoney = 0L;
    private int beeLine500KQuantity = 0;
    private long beeLine300KMoney = 0L;
    private int beeLine300KQuantity = 0;
    private long beeLine200KMoney = 0L;
    private int beeLine200KQuantity = 0;
    private long beeLine100KMoney = 0L;
    private int beeLine100KQuantity = 0;
    private long beeLine50KMoney = 0L;
    private int beeLine50KQuantity = 0;
    private long beeLine30KMoney = 0L;
    private int beeLine30KQuantity = 0;
    private long beeLine20KMoney = 0L;
    private int beeLine20KQuantity = 0;
    private long beeLine10KMoney = 0L;
    private int beeLine10KQuantity = 0;
    private long gateMoney = 0L;
    private long gate5MMoney = 0L;
    private int gate5MQuantity = 0;
    private long gate2MMoney = 0L;
    private int gate2MQuantity = 0;
    private long gate1MMoney = 0L;
    private int gate1MQuantity = 0;
    private long gate500KMoney = 0L;
    private int gate500KQuantity = 0;
    private long gate300KMoney = 0L;
    private int gate300KQuantity = 0;
    private long gate200KMoney = 0L;
    private int gate200KQuantity = 0;
    private long gate100KMoney = 0L;
    private int gate100KQuantity = 0;
    private long gate50KMoney = 0L;
    private int gate50KQuantity = 0;
    private long gate30KMoney = 0L;
    private int gate30KQuantity = 0;
    private long gate20KMoney = 0L;
    private int gate20KQuantity = 0;
    private long gate10KMoney = 0L;
    private int gate10KQuantity = 0;
    private long zingMoney = 0L;
    private long zing5MMoney = 0L;
    private int zing5MQuantity = 0;
    private long zing2MMoney = 0L;
    private int zing2MQuantity = 0;
    private long zing1MMoney = 0L;
    private int zing1MQuantity = 0;
    private long zing500KMoney = 0L;
    private int zing500KQuantity = 0;
    private long zing300KMoney = 0L;
    private int zing300KQuantity = 0;
    private long zing200KMoney = 0L;
    private int zing200KQuantity = 0;
    private long zing100KMoney = 0L;
    private int zing100KQuantity = 0;
    private long zing50KMoney = 0L;
    private int zing50KQuantity = 0;
    private long zing30KMoney = 0L;
    private int zing30KQuantity = 0;
    private long zing20KMoney = 0L;
    private int zing20KQuantity = 0;
    private long zing10KMoney = 0L;
    private int zing10KQuantity = 0;
    private long vcoinMoney = 0L;
    private long vcoin5MMoney = 0L;
    private int vcoin5MQuantity = 0;
    private long vcoin2MMoney = 0L;
    private int vcoin2MQuantity = 0;
    private long vcoin1MMoney = 0L;
    private int vcoin1MQuantity = 0;
    private long vcoin500KMoney = 0L;
    private int vcoin500KQuantity = 0;
    private long vcoin300KMoney = 0L;
    private int vcoin300KQuantity = 0;
    private long vcoin200KMoney = 0L;
    private int vcoin200KQuantity = 0;
    private long vcoin100KMoney = 0L;
    private int vcoin100KQuantity = 0;
    private long vcoin50KMoney = 0L;
    private int vcoin50KQuantity = 0;
    private long vcoin30KMoney = 0L;
    private int vcoin30KQuantity = 0;
    private long vcoin20KMoney = 0L;
    private int vcoin20KQuantity = 0;
    private long vcoin10KMoney = 0L;
    private int vcoin10KQuantity = 0;

    @Override
    public List<MoneyTotalRechargeByCardReponse> moneyTotalCashOutByCard(String timeStart, String timeEnd, String partner, String code) {
        MongoDatabase db = MongoDBConnectionFactory.getDB();
        BasicDBObject obj = new BasicDBObject();
        BasicDBObject objsort = new BasicDBObject();
        Document conditions = new Document();
        this.totalMoney = 0L;
        this.viettelMoney = 0L;
        this.viettel5MMoney = 0L;
        this.viettel5MQuantity = 0;
        this.viettel2MMoney = 0L;
        this.viettel2MQuantity = 0;
        this.viettel1MMoney = 0L;
        this.viettel1MQuantity = 0;
        this.viettel500KMoney = 0L;
        this.viettel500KQuantity = 0;
        this.viettel300KMoney = 0L;
        this.viettel300KQuantity = 0;
        this.viettel200KMoney = 0L;
        this.viettel200KQuantity = 0;
        this.viettel100KMoney = 0L;
        this.viettel100KQuantity = 0;
        this.viettel50KMoney = 0L;
        this.viettel50KQuantity = 0;
        this.viettel30KMoney = 0L;
        this.viettel30KQuantity = 0;
        this.viettel20KMoney = 0L;
        this.viettel20KQuantity = 0;
        this.viettel10KMoney = 0L;
        this.viettel10KQuantity = 0;
        this.vinaphoneMoney = 0L;
        this.vinaphone5MMoney = 0L;
        this.vinaphone5MQuantity = 0;
        this.vinaphone2MMoney = 0L;
        this.vinaphone2MQuantity = 0;
        this.vinaphone1MMoney = 0L;
        this.vinaphone1MQuantity = 0;
        this.vinaphone500KMoney = 0L;
        this.vinaphone500KQuantity = 0;
        this.vinaphone300KMoney = 0L;
        this.vinaphone300KQuantity = 0;
        this.vinaphone200KMoney = 0L;
        this.vinaphone200KQuantity = 0;
        this.vinaphone100KMoney = 0L;
        this.vinaphone100KQuantity = 0;
        this.vinaphone50KMoney = 0L;
        this.vinaphone50KQuantity = 0;
        this.vinaphone30KMoney = 0L;
        this.vinaphone30KQuantity = 0;
        this.vinaphone20KMoney = 0L;
        this.vinaphone20KQuantity = 0;
        this.vinaphone10KMoney = 0L;
        this.vinaphone10KQuantity = 0;
        this.mobifoneMoney = 0L;
        this.mobifone5MMoney = 0L;
        this.mobifone5MQuantity = 0;
        this.mobifone2MMoney = 0L;
        this.mobifone2MQuantity = 0;
        this.mobifone1MMoney = 0L;
        this.mobifone1MQuantity = 0;
        this.mobifone500KMoney = 0L;
        this.mobifone500KQuantity = 0;
        this.mobifone300KMoney = 0L;
        this.mobifone300KQuantity = 0;
        this.mobifone200KMoney = 0L;
        this.mobifone200KQuantity = 0;
        this.mobifone100KMoney = 0L;
        this.mobifone100KQuantity = 0;
        this.mobifone50KMoney = 0L;
        this.mobifone50KQuantity = 0;
        this.mobifone30KMoney = 0L;
        this.mobifone30KQuantity = 0;
        this.mobifone20KMoney = 0L;
        this.mobifone20KQuantity = 0;
        this.mobifone10KMoney = 0L;
        this.mobifone10KQuantity = 0;
        this.vietNamMobileMoney = 0L;
        this.vietNamMobile5MMoney = 0L;
        this.vietNamMobile5MQuantity = 0;
        this.vietNamMobile2MMoney = 0L;
        this.vietNamMobile2MQuantity = 0;
        this.vietNamMobile1MMoney = 0L;
        this.vietNamMobile1MQuantity = 0;
        this.vietNamMobile500KMoney = 0L;
        this.vietNamMobile500KQuantity = 0;
        this.vietNamMobile300KMoney = 0L;
        this.vietNamMobile300KQuantity = 0;
        this.vietNamMobile200KMoney = 0L;
        this.vietNamMobile200KQuantity = 0;
        this.vietNamMobile100KMoney = 0L;
        this.vietNamMobile100KQuantity = 0;
        this.vietNamMobile50KMoney = 0L;
        this.vietNamMobile50KQuantity = 0;
        this.vietNamMobile30KMoney = 0L;
        this.vietNamMobile30KQuantity = 0;
        this.vietNamMobile20KMoney = 0L;
        this.vietNamMobile20KQuantity = 0;
        this.vietNamMobile10KMoney = 0L;
        this.vietNamMobile10KQuantity = 0;
        this.beeLineMoney = 0L;
        this.beeLine5MMoney = 0L;
        this.beeLine5MQuantity = 0;
        this.beeLine2MMoney = 0L;
        this.beeLine2MQuantity = 0;
        this.beeLine1MMoney = 0L;
        this.beeLine1MQuantity = 0;
        this.beeLine500KMoney = 0L;
        this.beeLine500KQuantity = 0;
        this.beeLine300KMoney = 0L;
        this.beeLine300KQuantity = 0;
        this.beeLine200KMoney = 0L;
        this.beeLine200KQuantity = 0;
        this.beeLine100KMoney = 0L;
        this.beeLine100KQuantity = 0;
        this.beeLine50KMoney = 0L;
        this.beeLine50KQuantity = 0;
        this.beeLine30KMoney = 0L;
        this.beeLine30KQuantity = 0;
        this.beeLine20KMoney = 0L;
        this.beeLine20KQuantity = 0;
        this.beeLine10KMoney = 0L;
        this.beeLine10KQuantity = 0;
        this.gateMoney = 0L;
        this.gate5MMoney = 0L;
        this.gate5MQuantity = 0;
        this.gate2MMoney = 0L;
        this.gate2MQuantity = 0;
        this.gate1MMoney = 0L;
        this.gate1MQuantity = 0;
        this.gate500KMoney = 0L;
        this.gate500KQuantity = 0;
        this.gate300KMoney = 0L;
        this.gate300KQuantity = 0;
        this.gate200KMoney = 0L;
        this.gate200KQuantity = 0;
        this.gate100KMoney = 0L;
        this.gate100KQuantity = 0;
        this.gate50KMoney = 0L;
        this.gate50KQuantity = 0;
        this.gate30KMoney = 0L;
        this.gate30KQuantity = 0;
        this.gate20KMoney = 0L;
        this.gate20KQuantity = 0;
        this.gate10KMoney = 0L;
        this.gate10KQuantity = 0;
        this.zingMoney = 0L;
        this.zing5MMoney = 0L;
        this.zing5MQuantity = 0;
        this.zing2MMoney = 0L;
        this.zing2MQuantity = 0;
        this.zing1MMoney = 0L;
        this.zing1MQuantity = 0;
        this.zing500KMoney = 0L;
        this.zing500KQuantity = 0;
        this.zing300KMoney = 0L;
        this.zing300KQuantity = 0;
        this.zing200KMoney = 0L;
        this.zing200KQuantity = 0;
        this.zing100KMoney = 0L;
        this.zing100KQuantity = 0;
        this.zing50KMoney = 0L;
        this.zing50KQuantity = 0;
        this.zing30KMoney = 0L;
        this.zing30KQuantity = 0;
        this.zing20KMoney = 0L;
        this.zing20KQuantity = 0;
        this.zing10KMoney = 0L;
        this.zing10KQuantity = 0;
        this.vcoinMoney = 0L;
        this.vcoin5MMoney = 0L;
        this.vcoin5MQuantity = 0;
        this.vcoin2MMoney = 0L;
        this.vcoin2MQuantity = 0;
        this.vcoin1MMoney = 0L;
        this.vcoin1MQuantity = 0;
        this.vcoin500KMoney = 0L;
        this.vcoin500KQuantity = 0;
        this.vcoin300KMoney = 0L;
        this.vcoin300KQuantity = 0;
        this.vcoin200KMoney = 0L;
        this.vcoin200KQuantity = 0;
        this.vcoin100KMoney = 0L;
        this.vcoin100KQuantity = 0;
        this.vcoin50KMoney = 0L;
        this.vcoin50KQuantity = 0;
        this.vcoin30KMoney = 0L;
        this.vcoin30KQuantity = 0;
        this.vcoin20KMoney = 0L;
        this.vcoin20KQuantity = 0;
        this.vcoin10KMoney = 0L;
        this.vcoin10KQuantity = 0;
        objsort.put("_id", -1);
        if (!timeStart.isEmpty() && !timeEnd.isEmpty()) {
            obj.put("$gte", (Object)timeStart);
            obj.put("$lte", (Object)timeEnd);
            conditions.put("time_log", (Object)obj);
        }
        if (!partner.isEmpty()) {
            conditions.put("partner", (Object)partner);
        }
        if (!code.isEmpty()) {
            conditions.put("code", (Object)Integer.parseInt(code));
        }
        FindIterable iterable = null;
        iterable = db.getCollection("dvt_cash_out_by_card").find((Bson)new Document((Map)conditions)).sort((Bson)objsort);
        iterable.forEach((Block)new Block<Document>(){

            public void apply(Document document) {
                CashOutByCardDAOImpl cashOutByCardDAOImpl = CashOutByCardDAOImpl.this;
                cashOutByCardDAOImpl.totalMoney = cashOutByCardDAOImpl.totalMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                block10 : switch (document.getString((Object)"provider")) {
                    case "Viettel": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl2.viettelMoney = cashOutByCardDAOImpl2.viettelMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel5MQuantity = cashOutByCardDAOImpl2.viettel5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel5MMoney = cashOutByCardDAOImpl2.viettel5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel2MQuantity = cashOutByCardDAOImpl2.viettel2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel2MMoney = cashOutByCardDAOImpl2.viettel2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel1MQuantity = cashOutByCardDAOImpl2.viettel1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel1MMoney = cashOutByCardDAOImpl2.viettel1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel500KQuantity = cashOutByCardDAOImpl2.viettel500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel500KMoney = cashOutByCardDAOImpl2.viettel500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel300KQuantity = cashOutByCardDAOImpl2.viettel300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel300KMoney = cashOutByCardDAOImpl2.viettel300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel200KQuantity = cashOutByCardDAOImpl2.viettel200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel200KMoney = cashOutByCardDAOImpl2.viettel200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel100KQuantity = cashOutByCardDAOImpl2.viettel100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel100KMoney = cashOutByCardDAOImpl2.viettel100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel50KQuantity = cashOutByCardDAOImpl2.viettel50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel50KMoney = cashOutByCardDAOImpl2.viettel50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel30KQuantity = cashOutByCardDAOImpl2.viettel30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel30KMoney = cashOutByCardDAOImpl2.viettel30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel20KQuantity = cashOutByCardDAOImpl2.viettel20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel20KMoney = cashOutByCardDAOImpl2.viettel20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel10KQuantity = cashOutByCardDAOImpl2.viettel10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl2 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl2.viettel10KMoney = cashOutByCardDAOImpl2.viettel10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "Vinaphone": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl3.vinaphoneMoney = cashOutByCardDAOImpl3.vinaphoneMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone5MQuantity = cashOutByCardDAOImpl3.vinaphone5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone5MMoney = cashOutByCardDAOImpl3.vinaphone5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone2MQuantity = cashOutByCardDAOImpl3.vinaphone2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone2MMoney = cashOutByCardDAOImpl3.vinaphone2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone1MQuantity = cashOutByCardDAOImpl3.vinaphone1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone1MMoney = cashOutByCardDAOImpl3.vinaphone1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone500KQuantity = cashOutByCardDAOImpl3.vinaphone500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone500KMoney = cashOutByCardDAOImpl3.vinaphone500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone300KQuantity = cashOutByCardDAOImpl3.vinaphone300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone300KMoney = cashOutByCardDAOImpl3.vinaphone300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone200KQuantity = cashOutByCardDAOImpl3.vinaphone200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone200KMoney = cashOutByCardDAOImpl3.vinaphone200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone100KQuantity = cashOutByCardDAOImpl3.vinaphone100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone100KMoney = cashOutByCardDAOImpl3.vinaphone100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone50KQuantity = cashOutByCardDAOImpl3.vinaphone50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone50KMoney = cashOutByCardDAOImpl3.vinaphone50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone30KQuantity = cashOutByCardDAOImpl3.vinaphone30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone30KMoney = cashOutByCardDAOImpl3.vinaphone30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone20KQuantity = cashOutByCardDAOImpl3.vinaphone20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone20KMoney = cashOutByCardDAOImpl3.vinaphone20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone10KQuantity = cashOutByCardDAOImpl3.vinaphone10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl3 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl3.vinaphone10KMoney = cashOutByCardDAOImpl3.vinaphone10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "Mobifone": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl4.mobifoneMoney = cashOutByCardDAOImpl4.mobifoneMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone5MQuantity = cashOutByCardDAOImpl4.mobifone5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone5MMoney = cashOutByCardDAOImpl4.mobifone5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone2MQuantity = cashOutByCardDAOImpl4.mobifone2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone2MMoney = cashOutByCardDAOImpl4.mobifone2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone1MQuantity = cashOutByCardDAOImpl4.mobifone1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone1MMoney = cashOutByCardDAOImpl4.mobifone1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone500KQuantity = cashOutByCardDAOImpl4.mobifone500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone500KMoney = cashOutByCardDAOImpl4.mobifone500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone300KQuantity = cashOutByCardDAOImpl4.mobifone300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone300KMoney = cashOutByCardDAOImpl4.mobifone300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone200KQuantity = cashOutByCardDAOImpl4.mobifone200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone200KMoney = cashOutByCardDAOImpl4.mobifone200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone100KQuantity = cashOutByCardDAOImpl4.mobifone100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone100KMoney = cashOutByCardDAOImpl4.mobifone100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone50KQuantity = cashOutByCardDAOImpl4.mobifone50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone50KMoney = cashOutByCardDAOImpl4.mobifone50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone30KQuantity = cashOutByCardDAOImpl4.mobifone30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone30KMoney = cashOutByCardDAOImpl4.mobifone30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone20KQuantity = cashOutByCardDAOImpl4.mobifone20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone20KMoney = cashOutByCardDAOImpl4.mobifone20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone10KQuantity = cashOutByCardDAOImpl4.mobifone10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl4 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl4.mobifone10KMoney = cashOutByCardDAOImpl4.mobifone10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "VietNamMobile": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl5.vietNamMobileMoney = cashOutByCardDAOImpl5.vietNamMobileMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile5MQuantity = cashOutByCardDAOImpl5.vietNamMobile5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile5MMoney = cashOutByCardDAOImpl5.vietNamMobile5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile2MQuantity = cashOutByCardDAOImpl5.vietNamMobile2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile2MMoney = cashOutByCardDAOImpl5.vietNamMobile2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile1MQuantity = cashOutByCardDAOImpl5.vietNamMobile1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile1MMoney = cashOutByCardDAOImpl5.vietNamMobile1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile500KQuantity = cashOutByCardDAOImpl5.vietNamMobile500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile500KMoney = cashOutByCardDAOImpl5.vietNamMobile500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile300KQuantity = cashOutByCardDAOImpl5.vietNamMobile300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile300KMoney = cashOutByCardDAOImpl5.vietNamMobile300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile200KQuantity = cashOutByCardDAOImpl5.vietNamMobile200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile200KMoney = cashOutByCardDAOImpl5.vietNamMobile200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile100KQuantity = cashOutByCardDAOImpl5.vietNamMobile100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile100KMoney = cashOutByCardDAOImpl5.vietNamMobile100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile50KQuantity = cashOutByCardDAOImpl5.vietNamMobile50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile50KMoney = cashOutByCardDAOImpl5.vietNamMobile50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile30KQuantity = cashOutByCardDAOImpl5.vietNamMobile30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile30KMoney = cashOutByCardDAOImpl5.vietNamMobile30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile20KQuantity = cashOutByCardDAOImpl5.vietNamMobile20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile20KMoney = cashOutByCardDAOImpl5.vietNamMobile20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile10KQuantity = cashOutByCardDAOImpl5.vietNamMobile10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl5 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl5.vietNamMobile10KMoney = cashOutByCardDAOImpl5.vietNamMobile10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "BeeLine": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl6.beeLineMoney = cashOutByCardDAOImpl6.beeLineMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine5MQuantity = cashOutByCardDAOImpl6.beeLine5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine5MMoney = cashOutByCardDAOImpl6.beeLine5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine2MQuantity = cashOutByCardDAOImpl6.beeLine2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine2MMoney = cashOutByCardDAOImpl6.beeLine2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine1MQuantity = cashOutByCardDAOImpl6.beeLine1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine1MMoney = cashOutByCardDAOImpl6.beeLine1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine500KQuantity = cashOutByCardDAOImpl6.beeLine500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine500KMoney = cashOutByCardDAOImpl6.beeLine500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine300KQuantity = cashOutByCardDAOImpl6.beeLine300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine300KMoney = cashOutByCardDAOImpl6.beeLine300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine200KQuantity = cashOutByCardDAOImpl6.beeLine200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine200KMoney = cashOutByCardDAOImpl6.beeLine200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine100KQuantity = cashOutByCardDAOImpl6.beeLine100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine100KMoney = cashOutByCardDAOImpl6.beeLine100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine50KQuantity = cashOutByCardDAOImpl6.beeLine50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine50KMoney = cashOutByCardDAOImpl6.beeLine50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine30KQuantity = cashOutByCardDAOImpl6.beeLine30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine30KMoney = cashOutByCardDAOImpl6.beeLine30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine20KQuantity = cashOutByCardDAOImpl6.beeLine20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine20KMoney = cashOutByCardDAOImpl6.beeLine20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine10KQuantity = cashOutByCardDAOImpl6.beeLine10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl6 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl6.beeLine10KMoney = cashOutByCardDAOImpl6.beeLine10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "Gate": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl7.gateMoney = cashOutByCardDAOImpl7.gateMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate5MQuantity = cashOutByCardDAOImpl7.gate5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate5MMoney = cashOutByCardDAOImpl7.gate5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate2MQuantity = cashOutByCardDAOImpl7.gate2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate2MMoney = cashOutByCardDAOImpl7.gate2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate1MQuantity = cashOutByCardDAOImpl7.gate1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate1MMoney = cashOutByCardDAOImpl7.gate1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate500KQuantity = cashOutByCardDAOImpl7.gate500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate500KMoney = cashOutByCardDAOImpl7.gate500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate300KQuantity = cashOutByCardDAOImpl7.gate300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate300KMoney = cashOutByCardDAOImpl7.gate300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate200KQuantity = cashOutByCardDAOImpl7.gate200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate200KMoney = cashOutByCardDAOImpl7.gate200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate100KQuantity = cashOutByCardDAOImpl7.gate100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate100KMoney = cashOutByCardDAOImpl7.gate100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate50KQuantity = cashOutByCardDAOImpl7.gate50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate50KMoney = cashOutByCardDAOImpl7.gate50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate30KQuantity = cashOutByCardDAOImpl7.gate30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate30KMoney = cashOutByCardDAOImpl7.gate30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate20KQuantity = cashOutByCardDAOImpl7.gate20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate20KMoney = cashOutByCardDAOImpl7.gate20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate10KQuantity = cashOutByCardDAOImpl7.gate10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl7 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl7.gate10KMoney = cashOutByCardDAOImpl7.gate10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "Zing": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl8.zingMoney = cashOutByCardDAOImpl8.zingMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing5MQuantity = cashOutByCardDAOImpl8.zing5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing5MMoney = cashOutByCardDAOImpl8.zing5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing2MQuantity = cashOutByCardDAOImpl8.zing2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing2MMoney = cashOutByCardDAOImpl8.zing2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing1MQuantity = cashOutByCardDAOImpl8.zing1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing1MMoney = cashOutByCardDAOImpl8.zing1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing500KQuantity = cashOutByCardDAOImpl8.zing500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing500KMoney = cashOutByCardDAOImpl8.zing500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing300KQuantity = cashOutByCardDAOImpl8.zing300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing300KMoney = cashOutByCardDAOImpl8.zing300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing200KQuantity = cashOutByCardDAOImpl8.zing200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing200KMoney = cashOutByCardDAOImpl8.zing200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing100KQuantity = cashOutByCardDAOImpl8.zing100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing100KMoney = cashOutByCardDAOImpl8.zing100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing50KQuantity = cashOutByCardDAOImpl8.zing50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing50KMoney = cashOutByCardDAOImpl8.zing50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing30KQuantity = cashOutByCardDAOImpl8.zing30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing30KMoney = cashOutByCardDAOImpl8.zing30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing20KQuantity = cashOutByCardDAOImpl8.zing20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing20KMoney = cashOutByCardDAOImpl8.zing20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing10KQuantity = cashOutByCardDAOImpl8.zing10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl8 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl8.zing10KMoney = cashOutByCardDAOImpl8.zing10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                    case "Vcoin": {
                        CashOutByCardDAOImpl cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                        cashOutByCardDAOImpl9.vcoinMoney = cashOutByCardDAOImpl9.vcoinMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
                        switch (document.getInteger((Object)"amount")) {
                            case 5000000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin5MQuantity = cashOutByCardDAOImpl9.vcoin5MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin5MMoney = cashOutByCardDAOImpl9.vcoin5MMoney + (long)(5000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 2000000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin2MQuantity = cashOutByCardDAOImpl9.vcoin2MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin2MMoney = cashOutByCardDAOImpl9.vcoin2MMoney + (long)(2000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 1000000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin1MQuantity = cashOutByCardDAOImpl9.vcoin1MQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin1MMoney = cashOutByCardDAOImpl9.vcoin1MMoney + (long)(1000000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 500000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin500KQuantity = cashOutByCardDAOImpl9.vcoin500KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin500KMoney = cashOutByCardDAOImpl9.vcoin500KMoney + (long)(500000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 300000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin300KQuantity = cashOutByCardDAOImpl9.vcoin300KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin300KMoney = cashOutByCardDAOImpl9.vcoin300KMoney + (long)(300000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 200000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin200KQuantity = cashOutByCardDAOImpl9.vcoin200KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin200KMoney = cashOutByCardDAOImpl9.vcoin200KMoney + (long)(200000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 100000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin100KQuantity = cashOutByCardDAOImpl9.vcoin100KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin100KMoney = cashOutByCardDAOImpl9.vcoin100KMoney + (long)(100000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 50000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin50KQuantity = cashOutByCardDAOImpl9.vcoin50KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin50KMoney = cashOutByCardDAOImpl9.vcoin50KMoney + (long)(50000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 30000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin30KQuantity = cashOutByCardDAOImpl9.vcoin30KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin30KMoney = cashOutByCardDAOImpl9.vcoin30KMoney + (long)(30000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 20000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin20KQuantity = cashOutByCardDAOImpl9.vcoin20KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin20KMoney = cashOutByCardDAOImpl9.vcoin20KMoney + (long)(20000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                            case 10000: {
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin10KQuantity = cashOutByCardDAOImpl9.vcoin10KQuantity + document.getInteger((Object)"quantity");
                                cashOutByCardDAOImpl9 = CashOutByCardDAOImpl.this;
                                cashOutByCardDAOImpl9.vcoin10KMoney = cashOutByCardDAOImpl9.vcoin10KMoney + (long)(10000 * document.getInteger((Object)"quantity"));
                                break block10;
                            }
                        }
                        break;
                    }
                }
            }
        });
        ArrayList<MoneyTotalRechargeByCardReponse> listReponse = new ArrayList<MoneyTotalRechargeByCardReponse>();
        MoneyTotalRechargeByCardReponse tong = new MoneyTotalRechargeByCardReponse();
        tong.setName("Tong");
        tong.setValue(this.totalMoney);
        tong.setTrans((List)null);
        listReponse.add(tong);
        MoneyTotalRechargeByCardReponse viettel = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listViettelMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue viettelMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney5MFollowFace.setFaceValue(5000000);
        viettelMoney5MFollowFace.setQuantity(this.viettel5MQuantity);
        viettelMoney5MFollowFace.setMoneyTotal(this.viettel5MMoney);
        listViettelMoneyFollowFace.add(viettelMoney5MFollowFace);
        MoneyTotalFollowFaceValue viettelMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney2MFollowFace.setFaceValue(2000000);
        viettelMoney2MFollowFace.setQuantity(this.viettel2MQuantity);
        viettelMoney2MFollowFace.setMoneyTotal(this.viettel2MMoney);
        listViettelMoneyFollowFace.add(viettelMoney2MFollowFace);
        MoneyTotalFollowFaceValue viettelMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney1MFollowFace.setFaceValue(1000000);
        viettelMoney1MFollowFace.setQuantity(this.viettel1MQuantity);
        viettelMoney1MFollowFace.setMoneyTotal(this.viettel1MMoney);
        listViettelMoneyFollowFace.add(viettelMoney1MFollowFace);
        MoneyTotalFollowFaceValue viettelMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney500KFollowFace.setFaceValue(500000);
        viettelMoney500KFollowFace.setQuantity(this.viettel500KQuantity);
        viettelMoney500KFollowFace.setMoneyTotal(this.viettel500KMoney);
        listViettelMoneyFollowFace.add(viettelMoney500KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney300KFollowFace.setFaceValue(300000);
        viettelMoney300KFollowFace.setQuantity(this.viettel300KQuantity);
        viettelMoney300KFollowFace.setMoneyTotal(this.viettel300KMoney);
        listViettelMoneyFollowFace.add(viettelMoney300KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney200KFollowFace.setFaceValue(200000);
        viettelMoney200KFollowFace.setQuantity(this.viettel200KQuantity);
        viettelMoney200KFollowFace.setMoneyTotal(this.viettel200KMoney);
        listViettelMoneyFollowFace.add(viettelMoney200KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney100KFollowFace.setFaceValue(100000);
        viettelMoney100KFollowFace.setQuantity(this.viettel100KQuantity);
        viettelMoney100KFollowFace.setMoneyTotal(this.viettel100KMoney);
        listViettelMoneyFollowFace.add(viettelMoney100KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney50KFollowFace.setFaceValue(50000);
        viettelMoney50KFollowFace.setQuantity(this.viettel50KQuantity);
        viettelMoney50KFollowFace.setMoneyTotal(this.viettel50KMoney);
        listViettelMoneyFollowFace.add(viettelMoney50KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney30KFollowFace.setFaceValue(30000);
        viettelMoney30KFollowFace.setQuantity(this.viettel30KQuantity);
        viettelMoney30KFollowFace.setMoneyTotal(this.viettel30KMoney);
        listViettelMoneyFollowFace.add(viettelMoney30KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney20KFollowFace.setFaceValue(20000);
        viettelMoney20KFollowFace.setQuantity(this.viettel20KQuantity);
        viettelMoney20KFollowFace.setMoneyTotal(this.viettel20KMoney);
        listViettelMoneyFollowFace.add(viettelMoney20KFollowFace);
        MoneyTotalFollowFaceValue viettelMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        viettelMoney10KFollowFace.setFaceValue(10000);
        viettelMoney10KFollowFace.setQuantity(this.viettel10KQuantity);
        viettelMoney10KFollowFace.setMoneyTotal(this.viettel10KMoney);
        listViettelMoneyFollowFace.add(viettelMoney10KFollowFace);
        viettel.setName("Viettel");
        viettel.setValue(this.viettelMoney);
        viettel.setTrans(listViettelMoneyFollowFace);
        listReponse.add(viettel);
        MoneyTotalRechargeByCardReponse vinaphone = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listVinaphoneMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue vinaphoneMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney5MFollowFace.setFaceValue(5000000);
        vinaphoneMoney5MFollowFace.setQuantity(this.vinaphone5MQuantity);
        vinaphoneMoney5MFollowFace.setMoneyTotal(this.vinaphone5MMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney5MFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney2MFollowFace.setFaceValue(2000000);
        vinaphoneMoney2MFollowFace.setQuantity(this.vinaphone2MQuantity);
        vinaphoneMoney2MFollowFace.setMoneyTotal(this.vinaphone2MMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney2MFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney1MFollowFace.setFaceValue(1000000);
        vinaphoneMoney1MFollowFace.setQuantity(this.vinaphone1MQuantity);
        vinaphoneMoney1MFollowFace.setMoneyTotal(this.vinaphone1MMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney1MFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney500KFollowFace.setFaceValue(500000);
        vinaphoneMoney500KFollowFace.setQuantity(this.vinaphone500KQuantity);
        vinaphoneMoney500KFollowFace.setMoneyTotal(this.vinaphone500KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney500KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney300KFollowFace.setFaceValue(300000);
        vinaphoneMoney300KFollowFace.setQuantity(this.vinaphone300KQuantity);
        vinaphoneMoney300KFollowFace.setMoneyTotal(this.vinaphone300KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney300KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney200KFollowFace.setFaceValue(200000);
        vinaphoneMoney200KFollowFace.setQuantity(this.vinaphone200KQuantity);
        vinaphoneMoney200KFollowFace.setMoneyTotal(this.vinaphone200KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney200KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney100KFollowFace.setFaceValue(100000);
        vinaphoneMoney100KFollowFace.setQuantity(this.vinaphone100KQuantity);
        vinaphoneMoney100KFollowFace.setMoneyTotal(this.vinaphone100KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney100KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney50KFollowFace.setFaceValue(50000);
        vinaphoneMoney50KFollowFace.setQuantity(this.vinaphone50KQuantity);
        vinaphoneMoney50KFollowFace.setMoneyTotal(this.vinaphone50KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney50KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney30KFollowFace.setFaceValue(30000);
        vinaphoneMoney30KFollowFace.setQuantity(this.vinaphone30KQuantity);
        vinaphoneMoney30KFollowFace.setMoneyTotal(this.vinaphone30KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney30KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney20KFollowFace.setFaceValue(20000);
        vinaphoneMoney20KFollowFace.setQuantity(this.vinaphone20KQuantity);
        vinaphoneMoney20KFollowFace.setMoneyTotal(this.vinaphone20KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney20KFollowFace);
        MoneyTotalFollowFaceValue vinaphoneMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        vinaphoneMoney10KFollowFace.setFaceValue(10000);
        vinaphoneMoney10KFollowFace.setQuantity(this.vinaphone10KQuantity);
        vinaphoneMoney10KFollowFace.setMoneyTotal(this.vinaphone10KMoney);
        listVinaphoneMoneyFollowFace.add(vinaphoneMoney10KFollowFace);
        vinaphone.setName("Vinaphone");
        vinaphone.setValue(this.vinaphoneMoney);
        vinaphone.setTrans(listVinaphoneMoneyFollowFace);
        listReponse.add(vinaphone);
        MoneyTotalRechargeByCardReponse mobifone = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listMobifoneMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue mobifoneMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney5MFollowFace.setFaceValue(5000000);
        mobifoneMoney5MFollowFace.setQuantity(this.mobifone5MQuantity);
        mobifoneMoney5MFollowFace.setMoneyTotal(this.mobifone5MMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney5MFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney2MFollowFace.setFaceValue(2000000);
        mobifoneMoney2MFollowFace.setQuantity(this.mobifone2MQuantity);
        mobifoneMoney2MFollowFace.setMoneyTotal(this.mobifone2MMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney2MFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney1MFollowFace.setFaceValue(1000000);
        mobifoneMoney1MFollowFace.setQuantity(this.mobifone1MQuantity);
        mobifoneMoney1MFollowFace.setMoneyTotal(this.mobifone1MMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney1MFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney500KFollowFace.setFaceValue(500000);
        mobifoneMoney500KFollowFace.setQuantity(this.mobifone500KQuantity);
        mobifoneMoney500KFollowFace.setMoneyTotal(this.mobifone500KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney500KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney300KFollowFace.setFaceValue(300000);
        mobifoneMoney300KFollowFace.setQuantity(this.mobifone300KQuantity);
        mobifoneMoney300KFollowFace.setMoneyTotal(this.mobifone300KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney300KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney200KFollowFace.setFaceValue(200000);
        mobifoneMoney200KFollowFace.setQuantity(this.mobifone200KQuantity);
        mobifoneMoney200KFollowFace.setMoneyTotal(this.mobifone200KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney200KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney100KFollowFace.setFaceValue(100000);
        mobifoneMoney100KFollowFace.setQuantity(this.mobifone100KQuantity);
        mobifoneMoney100KFollowFace.setMoneyTotal(this.mobifone100KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney100KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney50KFollowFace.setFaceValue(50000);
        mobifoneMoney50KFollowFace.setQuantity(this.mobifone50KQuantity);
        mobifoneMoney50KFollowFace.setMoneyTotal(this.mobifone50KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney50KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney30KFollowFace.setFaceValue(30000);
        mobifoneMoney30KFollowFace.setQuantity(this.mobifone30KQuantity);
        mobifoneMoney30KFollowFace.setMoneyTotal(this.mobifone30KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney30KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney20KFollowFace.setFaceValue(20000);
        mobifoneMoney20KFollowFace.setQuantity(this.mobifone20KQuantity);
        mobifoneMoney20KFollowFace.setMoneyTotal(this.mobifone20KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney20KFollowFace);
        MoneyTotalFollowFaceValue mobifoneMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        mobifoneMoney10KFollowFace.setFaceValue(10000);
        mobifoneMoney10KFollowFace.setQuantity(this.mobifone10KQuantity);
        mobifoneMoney10KFollowFace.setMoneyTotal(this.mobifone10KMoney);
        listMobifoneMoneyFollowFace.add(mobifoneMoney10KFollowFace);
        mobifone.setName("Mobifone");
        mobifone.setValue(this.mobifoneMoney);
        mobifone.setTrans(listMobifoneMoneyFollowFace);
        listReponse.add(mobifone);
        MoneyTotalRechargeByCardReponse vietNamMobile = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listVietNamMobileMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue vietNamMobileMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney5MFollowFace.setFaceValue(5000000);
        vietNamMobileMoney5MFollowFace.setQuantity(this.vietNamMobile5MQuantity);
        vietNamMobileMoney5MFollowFace.setMoneyTotal(this.vietNamMobile5MMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney5MFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney2MFollowFace.setFaceValue(2000000);
        vietNamMobileMoney2MFollowFace.setQuantity(this.vietNamMobile2MQuantity);
        vietNamMobileMoney2MFollowFace.setMoneyTotal(this.vietNamMobile2MMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney2MFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney1MFollowFace.setFaceValue(1000000);
        vietNamMobileMoney1MFollowFace.setQuantity(this.vietNamMobile1MQuantity);
        vietNamMobileMoney1MFollowFace.setMoneyTotal(this.vietNamMobile1MMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney1MFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney500KFollowFace.setFaceValue(500000);
        vietNamMobileMoney500KFollowFace.setQuantity(this.vietNamMobile500KQuantity);
        vietNamMobileMoney500KFollowFace.setMoneyTotal(this.vietNamMobile500KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney500KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney300KFollowFace.setFaceValue(300000);
        vietNamMobileMoney300KFollowFace.setQuantity(this.vietNamMobile300KQuantity);
        vietNamMobileMoney300KFollowFace.setMoneyTotal(this.vietNamMobile300KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney300KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney200KFollowFace.setFaceValue(200000);
        vietNamMobileMoney200KFollowFace.setQuantity(this.vietNamMobile200KQuantity);
        vietNamMobileMoney200KFollowFace.setMoneyTotal(this.vietNamMobile200KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney200KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney100KFollowFace.setFaceValue(100000);
        vietNamMobileMoney100KFollowFace.setQuantity(this.vietNamMobile100KQuantity);
        vietNamMobileMoney100KFollowFace.setMoneyTotal(this.vietNamMobile100KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney100KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney50KFollowFace.setFaceValue(50000);
        vietNamMobileMoney50KFollowFace.setQuantity(this.vietNamMobile50KQuantity);
        vietNamMobileMoney50KFollowFace.setMoneyTotal(this.vietNamMobile50KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney50KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney30KFollowFace.setFaceValue(30000);
        vietNamMobileMoney30KFollowFace.setQuantity(this.vietNamMobile30KQuantity);
        vietNamMobileMoney30KFollowFace.setMoneyTotal(this.vietNamMobile30KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney30KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney20KFollowFace.setFaceValue(20000);
        vietNamMobileMoney20KFollowFace.setQuantity(this.vietNamMobile20KQuantity);
        vietNamMobileMoney20KFollowFace.setMoneyTotal(this.vietNamMobile20KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney20KFollowFace);
        MoneyTotalFollowFaceValue vietNamMobileMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        vietNamMobileMoney10KFollowFace.setFaceValue(10000);
        vietNamMobileMoney10KFollowFace.setQuantity(this.vietNamMobile10KQuantity);
        vietNamMobileMoney10KFollowFace.setMoneyTotal(this.vietNamMobile10KMoney);
        listVietNamMobileMoneyFollowFace.add(vietNamMobileMoney10KFollowFace);
        vietNamMobile.setName("VietNamMobile");
        vietNamMobile.setValue(this.vietNamMobileMoney);
        vietNamMobile.setTrans(listVietNamMobileMoneyFollowFace);
        listReponse.add(vietNamMobile);
        MoneyTotalRechargeByCardReponse beeLine = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listBeeLineMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue beeLineMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney5MFollowFace.setFaceValue(5000000);
        beeLineMoney5MFollowFace.setQuantity(this.beeLine5MQuantity);
        beeLineMoney5MFollowFace.setMoneyTotal(this.beeLine5MMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney5MFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney2MFollowFace.setFaceValue(2000000);
        beeLineMoney2MFollowFace.setQuantity(this.beeLine2MQuantity);
        beeLineMoney2MFollowFace.setMoneyTotal(this.beeLine2MMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney2MFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney1MFollowFace.setFaceValue(1000000);
        beeLineMoney1MFollowFace.setQuantity(this.beeLine1MQuantity);
        beeLineMoney1MFollowFace.setMoneyTotal(this.beeLine1MMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney1MFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney500KFollowFace.setFaceValue(500000);
        beeLineMoney500KFollowFace.setQuantity(this.beeLine500KQuantity);
        beeLineMoney500KFollowFace.setMoneyTotal(this.beeLine500KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney500KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney300KFollowFace.setFaceValue(300000);
        beeLineMoney300KFollowFace.setQuantity(this.beeLine300KQuantity);
        beeLineMoney300KFollowFace.setMoneyTotal(this.beeLine300KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney300KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney200KFollowFace.setFaceValue(200000);
        beeLineMoney200KFollowFace.setQuantity(this.beeLine200KQuantity);
        beeLineMoney200KFollowFace.setMoneyTotal(this.beeLine200KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney200KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney100KFollowFace.setFaceValue(100000);
        beeLineMoney100KFollowFace.setQuantity(this.beeLine100KQuantity);
        beeLineMoney100KFollowFace.setMoneyTotal(this.beeLine100KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney100KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney50KFollowFace.setFaceValue(50000);
        beeLineMoney50KFollowFace.setQuantity(this.beeLine50KQuantity);
        beeLineMoney50KFollowFace.setMoneyTotal(this.beeLine50KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney50KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney30KFollowFace.setFaceValue(30000);
        beeLineMoney30KFollowFace.setQuantity(this.beeLine30KQuantity);
        beeLineMoney30KFollowFace.setMoneyTotal(this.beeLine30KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney30KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney20KFollowFace.setFaceValue(20000);
        beeLineMoney20KFollowFace.setQuantity(this.beeLine20KQuantity);
        beeLineMoney20KFollowFace.setMoneyTotal(this.beeLine20KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney20KFollowFace);
        MoneyTotalFollowFaceValue beeLineMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        beeLineMoney10KFollowFace.setFaceValue(10000);
        beeLineMoney10KFollowFace.setQuantity(this.beeLine10KQuantity);
        beeLineMoney10KFollowFace.setMoneyTotal(this.beeLine10KMoney);
        listBeeLineMoneyFollowFace.add(beeLineMoney10KFollowFace);
        beeLine.setName("BeeLine");
        beeLine.setValue(this.beeLineMoney);
        beeLine.setTrans(listBeeLineMoneyFollowFace);
        listReponse.add(beeLine);
        MoneyTotalRechargeByCardReponse gate = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> listGateMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue gateMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney5MFollowFace.setFaceValue(5000000);
        gateMoney5MFollowFace.setQuantity(this.gate5MQuantity);
        gateMoney5MFollowFace.setMoneyTotal(this.gate5MMoney);
        listGateMoneyFollowFace.add(gateMoney5MFollowFace);
        MoneyTotalFollowFaceValue gateMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney2MFollowFace.setFaceValue(2000000);
        gateMoney2MFollowFace.setQuantity(this.gate2MQuantity);
        gateMoney2MFollowFace.setMoneyTotal(this.gate2MMoney);
        listGateMoneyFollowFace.add(gateMoney2MFollowFace);
        MoneyTotalFollowFaceValue gateMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney1MFollowFace.setFaceValue(1000000);
        gateMoney1MFollowFace.setQuantity(this.gate1MQuantity);
        gateMoney1MFollowFace.setMoneyTotal(this.gate1MMoney);
        listGateMoneyFollowFace.add(gateMoney1MFollowFace);
        MoneyTotalFollowFaceValue gateMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney500KFollowFace.setFaceValue(500000);
        gateMoney500KFollowFace.setQuantity(this.gate500KQuantity);
        gateMoney500KFollowFace.setMoneyTotal(this.gate500KMoney);
        listGateMoneyFollowFace.add(gateMoney500KFollowFace);
        MoneyTotalFollowFaceValue gateMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney300KFollowFace.setFaceValue(300000);
        gateMoney300KFollowFace.setQuantity(this.gate300KQuantity);
        gateMoney300KFollowFace.setMoneyTotal(this.gate300KMoney);
        listGateMoneyFollowFace.add(gateMoney300KFollowFace);
        MoneyTotalFollowFaceValue gateMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney200KFollowFace.setFaceValue(200000);
        gateMoney200KFollowFace.setQuantity(this.gate200KQuantity);
        gateMoney200KFollowFace.setMoneyTotal(this.gate200KMoney);
        listGateMoneyFollowFace.add(gateMoney200KFollowFace);
        MoneyTotalFollowFaceValue gateMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney100KFollowFace.setFaceValue(100000);
        gateMoney100KFollowFace.setQuantity(this.gate100KQuantity);
        gateMoney100KFollowFace.setMoneyTotal(this.gate100KMoney);
        listGateMoneyFollowFace.add(gateMoney100KFollowFace);
        MoneyTotalFollowFaceValue gateMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney50KFollowFace.setFaceValue(50000);
        gateMoney50KFollowFace.setQuantity(this.gate50KQuantity);
        gateMoney50KFollowFace.setMoneyTotal(this.gate50KMoney);
        listGateMoneyFollowFace.add(gateMoney50KFollowFace);
        MoneyTotalFollowFaceValue gateMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney30KFollowFace.setFaceValue(30000);
        gateMoney30KFollowFace.setQuantity(this.gate30KQuantity);
        gateMoney30KFollowFace.setMoneyTotal(this.gate30KMoney);
        listGateMoneyFollowFace.add(gateMoney30KFollowFace);
        MoneyTotalFollowFaceValue gateMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney20KFollowFace.setFaceValue(20000);
        gateMoney20KFollowFace.setQuantity(this.gate20KQuantity);
        gateMoney20KFollowFace.setMoneyTotal(this.gate20KMoney);
        listGateMoneyFollowFace.add(gateMoney20KFollowFace);
        MoneyTotalFollowFaceValue gateMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        gateMoney10KFollowFace.setFaceValue(10000);
        gateMoney10KFollowFace.setQuantity(this.gate10KQuantity);
        gateMoney10KFollowFace.setMoneyTotal(this.gate10KMoney);
        listGateMoneyFollowFace.add(gateMoney10KFollowFace);
        gate.setName("Gate");
        gate.setValue(this.gateMoney);
        gate.setTrans(listGateMoneyFollowFace);
        listReponse.add(gate);
        MoneyTotalRechargeByCardReponse zing = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> lisZingMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue zingMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney5MFollowFace.setFaceValue(5000000);
        zingMoney5MFollowFace.setQuantity(this.zing5MQuantity);
        zingMoney5MFollowFace.setMoneyTotal(this.zing5MMoney);
        lisZingMoneyFollowFace.add(zingMoney5MFollowFace);
        MoneyTotalFollowFaceValue zingMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney2MFollowFace.setFaceValue(2000000);
        zingMoney2MFollowFace.setQuantity(this.zing2MQuantity);
        zingMoney2MFollowFace.setMoneyTotal(this.zing2MMoney);
        lisZingMoneyFollowFace.add(zingMoney2MFollowFace);
        MoneyTotalFollowFaceValue zingMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney1MFollowFace.setFaceValue(1000000);
        zingMoney1MFollowFace.setQuantity(this.zing1MQuantity);
        zingMoney1MFollowFace.setMoneyTotal(this.zing1MMoney);
        lisZingMoneyFollowFace.add(zingMoney1MFollowFace);
        MoneyTotalFollowFaceValue zingMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney500KFollowFace.setFaceValue(500000);
        zingMoney500KFollowFace.setQuantity(this.zing500KQuantity);
        zingMoney500KFollowFace.setMoneyTotal(this.zing500KMoney);
        lisZingMoneyFollowFace.add(zingMoney500KFollowFace);
        MoneyTotalFollowFaceValue zingMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney300KFollowFace.setFaceValue(300000);
        zingMoney300KFollowFace.setQuantity(this.zing300KQuantity);
        zingMoney300KFollowFace.setMoneyTotal(this.zing300KMoney);
        lisZingMoneyFollowFace.add(zingMoney300KFollowFace);
        MoneyTotalFollowFaceValue zingMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney200KFollowFace.setFaceValue(200000);
        zingMoney200KFollowFace.setQuantity(this.zing200KQuantity);
        zingMoney200KFollowFace.setMoneyTotal(this.zing200KMoney);
        lisZingMoneyFollowFace.add(zingMoney200KFollowFace);
        MoneyTotalFollowFaceValue zingMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney100KFollowFace.setFaceValue(100000);
        zingMoney100KFollowFace.setQuantity(this.zing100KQuantity);
        zingMoney100KFollowFace.setMoneyTotal(this.zing100KMoney);
        lisZingMoneyFollowFace.add(zingMoney100KFollowFace);
        MoneyTotalFollowFaceValue zingMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney50KFollowFace.setFaceValue(50000);
        zingMoney50KFollowFace.setQuantity(this.zing50KQuantity);
        zingMoney50KFollowFace.setMoneyTotal(this.zing50KMoney);
        lisZingMoneyFollowFace.add(zingMoney50KFollowFace);
        MoneyTotalFollowFaceValue zingMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney30KFollowFace.setFaceValue(30000);
        zingMoney30KFollowFace.setQuantity(this.zing30KQuantity);
        zingMoney30KFollowFace.setMoneyTotal(this.zing30KMoney);
        lisZingMoneyFollowFace.add(zingMoney30KFollowFace);
        MoneyTotalFollowFaceValue zingMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney20KFollowFace.setFaceValue(20000);
        zingMoney20KFollowFace.setQuantity(this.zing20KQuantity);
        zingMoney20KFollowFace.setMoneyTotal(this.zing20KMoney);
        lisZingMoneyFollowFace.add(zingMoney20KFollowFace);
        MoneyTotalFollowFaceValue zingMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        zingMoney10KFollowFace.setFaceValue(10000);
        zingMoney10KFollowFace.setQuantity(this.zing10KQuantity);
        zingMoney10KFollowFace.setMoneyTotal(this.zing10KMoney);
        lisZingMoneyFollowFace.add(zingMoney10KFollowFace);
        zing.setName("Zing");
        zing.setValue(this.zingMoney);
        zing.setTrans(lisZingMoneyFollowFace);
        listReponse.add(zing);
        MoneyTotalRechargeByCardReponse vcoin = new MoneyTotalRechargeByCardReponse();
        ArrayList<MoneyTotalFollowFaceValue> lisVcoinMoneyFollowFace = new ArrayList<MoneyTotalFollowFaceValue>();
        MoneyTotalFollowFaceValue vcoinMoney5MFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney5MFollowFace.setFaceValue(5000000);
        vcoinMoney5MFollowFace.setQuantity(this.vcoin5MQuantity);
        vcoinMoney5MFollowFace.setMoneyTotal(this.vcoin5MMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney5MFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney2MFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney2MFollowFace.setFaceValue(2000000);
        vcoinMoney2MFollowFace.setQuantity(this.vcoin2MQuantity);
        vcoinMoney2MFollowFace.setMoneyTotal(this.vcoin2MMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney2MFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney1MFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney1MFollowFace.setFaceValue(1000000);
        vcoinMoney1MFollowFace.setQuantity(this.vcoin1MQuantity);
        vcoinMoney1MFollowFace.setMoneyTotal(this.vcoin1MMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney1MFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney500KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney500KFollowFace.setFaceValue(500000);
        vcoinMoney500KFollowFace.setQuantity(this.vcoin500KQuantity);
        vcoinMoney500KFollowFace.setMoneyTotal(this.vcoin500KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney500KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney300KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney300KFollowFace.setFaceValue(300000);
        vcoinMoney300KFollowFace.setQuantity(this.vcoin300KQuantity);
        vcoinMoney300KFollowFace.setMoneyTotal(this.vcoin300KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney300KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney200KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney200KFollowFace.setFaceValue(200000);
        vcoinMoney200KFollowFace.setQuantity(this.vcoin200KQuantity);
        vcoinMoney200KFollowFace.setMoneyTotal(this.vcoin200KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney200KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney100KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney100KFollowFace.setFaceValue(100000);
        vcoinMoney100KFollowFace.setQuantity(this.vcoin100KQuantity);
        vcoinMoney100KFollowFace.setMoneyTotal(this.vcoin100KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney100KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney50KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney50KFollowFace.setFaceValue(50000);
        vcoinMoney50KFollowFace.setQuantity(this.vcoin50KQuantity);
        vcoinMoney50KFollowFace.setMoneyTotal(this.vcoin50KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney50KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney30KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney30KFollowFace.setFaceValue(30000);
        vcoinMoney30KFollowFace.setQuantity(this.vcoin30KQuantity);
        vcoinMoney30KFollowFace.setMoneyTotal(this.vcoin30KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney30KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney20KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney20KFollowFace.setFaceValue(20000);
        vcoinMoney20KFollowFace.setQuantity(this.vcoin20KQuantity);
        vcoinMoney20KFollowFace.setMoneyTotal(this.vcoin20KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney20KFollowFace);
        MoneyTotalFollowFaceValue vcoinMoney10KFollowFace = new MoneyTotalFollowFaceValue();
        vcoinMoney10KFollowFace.setFaceValue(10000);
        vcoinMoney10KFollowFace.setQuantity(this.vcoin10KQuantity);
        vcoinMoney10KFollowFace.setMoneyTotal(this.vcoin10KMoney);
        lisVcoinMoneyFollowFace.add(vcoinMoney10KFollowFace);
        vcoin.setName("Vcoin");
        vcoin.setValue(this.vcoinMoney);
        vcoin.setTrans(lisVcoinMoneyFollowFace);
        listReponse.add(vcoin);
        return listReponse;
    }

    @Override
    public List<CashOutByCardResponse> searchCashOutByCard(String nickName, String provider, String softpin, String code, String timeStart, String timeEnd, int page, String transId, String partner) {
        final ArrayList<CashOutByCardResponse> results = new ArrayList<CashOutByCardResponse>();
        MongoDatabase db = MongoDBConnectionFactory.getDB();
        FindIterable iterable = null;
        BasicDBObject obj = new BasicDBObject();
        BasicDBObject objsort = new BasicDBObject();
        Document conditions = new Document();
        objsort.put("_id", -1);
        int num_start = (page - 1) * 50;
        int num_end = 50;
        if (transId != null && !transId.equals("")) {
            conditions.put("reference_id", (Object)transId);
        }
        if (nickName != null && !nickName.equals("")) {
            conditions.put("nick_name", (Object)nickName);
        }
        if (provider != null && !provider.equals("")) {
            conditions.put("provider", (Object)provider);
        }
        if (softpin != null && !softpin.equals("")) {
            conditions.put("softpin", (Object)softpin);
        }
        if (code != null && !code.equals("")) {
            conditions.put("code", (Object)Integer.parseInt(code));
        }
        if (partner != null && !partner.equals("")) {
            conditions.put("partner", (Object)partner);
        }
        if (timeStart != null && !timeStart.equals("") && timeEnd != null && !timeEnd.equals("")) {
            obj.put("$gte", (Object)timeStart);
            obj.put("$lte", (Object)timeEnd);
            conditions.put("time_log", (Object)obj);
        }
        iterable = db.getCollection("dvt_cash_out_by_card").find((Bson)new Document((Map)conditions)).sort((Bson)objsort).skip(num_start).limit(50);
        iterable.forEach((Block)new Block<Document>(){

            public void apply(Document document) {
                CashOutByCardResponse bank = new CashOutByCardResponse();
                bank.referenceId = document.getString((Object)"reference_id");
                bank.nickName = document.getString((Object)"nick_name");
                bank.provider = document.getString((Object)"provider");
                bank.amount = document.getInteger((Object)"amount");
                bank.quantity = document.getInteger((Object)"quantity");
                bank.softpin = document.getString((Object)"softpin");
                bank.status = document.getInteger((Object)"status");
                bank.message = document.getString((Object)"message");
                bank.sign = document.getString((Object)"sign");
                bank.code = document.getInteger((Object)"code");
                bank.timeLog = document.getString((Object)"time_log");
                bank.updateTime = document.getString((Object)"update_time");
                bank.partner = document.getString((Object)"partner");
                results.add(bank);
            }
        });
        return results;
    }

    @Override
    public int countSearchCashOutByCard(String nickName, String provider, String softpin, String code, String timeStart, String timeEnd, String transId, String partner) {
        MongoDatabase db = MongoDBConnectionFactory.getDB();
        BasicDBObject obj = new BasicDBObject();
        BasicDBObject objsort = new BasicDBObject();
        Document conditions = new Document();
        objsort.put("_id", -1);
        if (transId != null && !transId.equals("")) {
            conditions.put("reference_id", (Object)transId);
        }
        if (nickName != null && !nickName.equals("")) {
            conditions.put("nick_name", (Object)nickName);
        }
        if (provider != null && !provider.equals("")) {
            conditions.put("provider", (Object)provider);
        }
        if (softpin != null && !softpin.equals("")) {
            conditions.put("softpin", (Object)softpin);
        }
        if (code != null && !code.equals("")) {
            conditions.put("code", (Object)Integer.parseInt(code));
        }
        if (partner != null && !partner.equals("")) {
            conditions.put("partner", (Object)partner);
        }
        if (timeStart != null && !timeStart.equals("") && timeEnd != null && !timeEnd.equals("")) {
            obj.put("$gte", (Object)timeStart);
            obj.put("$lte", (Object)timeEnd);
            conditions.put("time_log", (Object)obj);
        }
        int record = (int)db.getCollection("dvt_cash_out_by_card").count((Bson)new Document((Map)conditions));
        return record;
    }

    @Override
    public long moneyTotal(String nickName, String provider, String softpin, String code, String timeStart, String timeEnd, String transId, String partner) {
        this.totalMoney = 0L;
        MongoDatabase db = MongoDBConnectionFactory.getDB();
        BasicDBObject obj = new BasicDBObject();
        BasicDBObject objsort = new BasicDBObject();
        FindIterable iterable = null;
        Document conditions = new Document();
        objsort.put("_id", -1);
        if (transId != null && !transId.equals("")) {
            conditions.put("reference_id", (Object)transId);
        }
        if (nickName != null && !nickName.equals("")) {
            conditions.put("nick_name", (Object)nickName);
        }
        if (provider != null && !provider.equals("")) {
            conditions.put("provider", (Object)provider);
        }
        if (softpin != null && !softpin.equals("")) {
            conditions.put("softpin", (Object)softpin);
        }
        if (partner != null && !partner.equals("")) {
            conditions.put("partner", (Object)partner);
        }
        if (code != null && !code.equals("")) {
            conditions.put("code", (Object)Integer.parseInt(code));
        } else {
            BasicDBObject query1 = new BasicDBObject("code", (Object)Integer.parseInt("34"));
            BasicDBObject query2 = new BasicDBObject("code", (Object)Integer.parseInt("0"));
            ArrayList<BasicDBObject> myList = new ArrayList<BasicDBObject>();
            myList.add(query1);
            myList.add(query2);
            conditions.put("$or", myList);
        }
        if (!timeStart.isEmpty() && !timeEnd.isEmpty()) {
            obj.put("$gte", (Object)timeStart);
            obj.put("$lte", (Object)timeEnd);
            conditions.put("time_log", (Object)obj);
        }
        iterable = db.getCollection("dvt_cash_out_by_card").find((Bson)new Document((Map)conditions)).sort((Bson)objsort);
        iterable.forEach((Block)new Block<Document>(){

            public void apply(Document document) {
                CashOutByCardDAOImpl cashOutByCardDAOImpl = CashOutByCardDAOImpl.this;
                cashOutByCardDAOImpl.totalMoney = cashOutByCardDAOImpl.totalMoney + (long)(document.getInteger((Object)"amount") * document.getInteger((Object)"quantity"));
            }
        });
        return this.totalMoney;
    }

    @Override
    public List<CashOutByCardResponse> exportDataCashOutByCard(String provider, String code, String timeStart, String timeEnd, String partner, String amount) {
        final ArrayList<CashOutByCardResponse> results = new ArrayList<CashOutByCardResponse>();
        MongoDatabase db = MongoDBConnectionFactory.getDB();
        FindIterable iterable = null;
        BasicDBObject obj = new BasicDBObject();
        BasicDBObject objsort = new BasicDBObject();
        Document conditions = new Document();
        objsort.put("_id", -1);
        if (provider != null && !provider.equals("")) {
            conditions.put("provider", (Object)provider);
        }
        if (amount != null && !amount.equals("")) {
            conditions.put("amount", (Object)Integer.parseInt(amount));
        }
        if (code != null && !code.equals("")) {
            conditions.put("code", (Object)Integer.parseInt(code));
        }
        if (partner != null && !partner.equals("")) {
            conditions.put("partner", (Object)partner);
        }
        if (timeStart != null && !timeStart.equals("") && timeEnd != null && !timeEnd.equals("")) {
            obj.put("$gte", (Object)timeStart);
            obj.put("$lte", (Object)timeEnd);
            conditions.put("time_log", (Object)obj);
        }
        iterable = db.getCollection("dvt_cash_out_by_card").find((Bson)new Document((Map)conditions)).sort((Bson)objsort);
        iterable.forEach((Block)new Block<Document>(){

            public void apply(Document document) {
                CashOutByCardResponse bank = new CashOutByCardResponse();
                bank.referenceId = document.getString((Object)"reference_id");
                bank.nickName = document.getString((Object)"nick_name");
                bank.provider = document.getString((Object)"provider");
                bank.amount = document.getInteger((Object)"amount");
                bank.quantity = document.getInteger((Object)"quantity");
                bank.softpin = document.getString((Object)"softpin");
                bank.status = document.getInteger((Object)"status");
                bank.message = document.getString((Object)"message");
                bank.sign = document.getString((Object)"sign");
                bank.code = document.getInteger((Object)"code");
                bank.timeLog = document.getString((Object)"time_log");
                bank.updateTime = document.getString((Object)"update_time");
                bank.partner = document.getString((Object)"partner");
                results.add(bank);
            }
        });
        return results;
    }

}

