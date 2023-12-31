/*
 * Decompiled with CFR 0.144.
 */
package com.vinplay.vbee.common.statics;

import java.util.Arrays;
import java.util.List;

public class Consts {
    public static final String DB_CONFIG_FILE = "config/db_pool.properties";
    public static final String HAZELCAST_CONFIG_FILE = "config/hazelcast.properties";
    public static final String MONGO_CONFIG_FILE = "config/mongo.properties";
    public static final String RMQ_CONFIG_FILE = "config/rabbitmq_config.xml";
    public static final String API_PORTAL_CONFIG_FILE = "config/api_portal.xml";
    public static final String API_OTP_CONFIG_FILE = "config/api_otp.xml";
    public static final String API_BACKEND_CONFIG_FILE = "config/api_backend.xml";
    public static final String APP_CONFIG_FILE = "config/app_config.properties";
    public static final int TD_KHOP_LENH_TOI_THIEU = 2000;
    public static final int TD_1_VAN_KHOP_LENH_TOI_THIEU = 10000;
    public static final int TCA_KHOP_LENH_TOI_THIEU = 2000;
    public static final int TCA_1_VAN_KHOP_LENH_TOI_THIEU = 5000;
    public static final String VBEE_LOGGER = "vbee";
    public static final String API_PORTAL_LOGGER = "api";
    public static final String PAY_LOGGER = "pay";
    public static final String VTCPAY_LOGGER = "vtc_pay";
    public static final String BACKEND_LOGGER = "backend";
    public static final String USER_CORE_LOGGER = "user_core";
    public static final String REPORT_LOGGER = "report";
    public static final String RECHARGE_LOGGER = "recharge";
    public static final String CASHOUT_LOGGER = "cashout";
    public static final String VBEE_STATISTIC_LOGGER = "vbeeStatistic";
    public static final String CACHE_USER = "users";
    public static final String CACHE_USER_EXTRA_INFO = "cache_user_extra_info";
    public static final String CACHE_HU_GAME_BAI = "huGameBai";
    public static final String CACHE_FREEZE = "freeze";
    public static final String CACHE_TAI_XIU = "cacheTaiXiu";
    public static final String CACHE_WIN_THANH_DU_TX = "cacheWinThanhDuTX";
    public static final String CACHE_LOSS_THANH_DU_TX = "cacheLossThanhDuTX";
    public static final String CACHE_RUT_LOC_TX = "cacheRutLocTX";
    public static final String CACHE_GOOGLE = "cacheGoogle";
    public static final String CACHE_FACEBOOK = "cacheFacebook";
    public static final String CACHE_VP_MINIGAME = "VPMinigame";
    public static final String CACHE_TOI_CHON_CA = "cacheToiChonCa";
    public static final String CACHE_CONFIG = "cacheConfig";
    public static final String CACHE_GAME_BAI = "cacheGameBai";
    public static final String CACHE_CAPTCHA = "cacheCaptcha";
    public static final String CACHE_BROADCAST = "cacheBroadcast";
    public static final String CACHE_KHO_BAU_FREE = "cacheKhoBauFree";
    public static final String CACHE_TOP = "cacheTop";
    public static final String CACH_TRANSACTION = "cacheTransaction";
    public static final String CACHE_REPORT = "cacheReports";
    public static final String CACHE_TOP_CAO_THU_VIN = "cacheTopCaoThuVin";
    public static final String CACHE_TOP_CAO_THU_XU = "cacheTopCaoThuXu";
    public static final String CACHE_LOG_PORTAL = "cacheLogPortal";
    public static final String CACHE_USERS_PLAY_GAME = "cacheUsersPlayGame";
    public static final String CACHE_EVENT_VP_BONUS = "cacheEventVpBonus";
    public static final String CACHE_API_OTP = "cacheApiOtp";
    public static final String CACHE_SLOT_FREE = "cacheSlotFree";
    public static final String CACHE_DVT = "cacheDvt";
    public static final String CACHE_TOKEN = "cacheToken";
    public static final String CACHE_USER_MISSION_VIN = "cacheUserMissionVin";
    public static final String CACHE_USER_MISSION_XU = "cacheUserMissionXu";
    public static final String CACHE_AGENT_COMMISSION = "cacheAgentCommission";
    public static final String PAYMENT_QUEUE = "queue_payment";
    public static final String PAYMENT_QUEUE_MINIGAME = "queue_payment_minigame";
    public static final String PAYMENT_QUEUE_GAME_BAI = "queue_payment_gamebai";
    public static final String QUEUE_LOG_MONEY = "queue_log_money";
    public static final String QUEUE_LOG_MONEY_EXTRA = "queue_log_money_extra";
    public static final String QUEUE_LOG_CHUYEN_TIEN_DAI_LY = "queue_log_chuyen_tien_dai_ly";
    public static final String QUEUE_OTP = "queue_otp";
    public static final String QUEUE_DVT = "queue_dvt";
    public static final String QUEUE_HU_GAMEBAI = "queue_hu_gamebai";
    public static final String QUEUE_LOG_GAMEBAI = "queue_log_gamebai";
    public static final String QUEUE_POT = "queue_pot";
    public static final String QUEUE_FUND = "queue_fund";
    public static final String QUEUE_VQMM = "queue_vqmm";
    public static final String QUEUE_TAIXIU = "queue_taixiu";
    public static final String QUEUE_MINIPOKER = "queue_minipoker";
    public static final String QUEUE_CAOTHAP = "queue_caothap";
    public static final String QUEUE_BAUCUA = "queue_baucua";
    public static final String QUEUE_POKEGO = "queue_pokego";
    public static final String QUEUE_TOP = "queue_top";
    public static final String QUEUE_SERVER_INFO = "queue_server_info";
    public static final String QUEUE_KHO_BAU = "queue_kho_bau";
    public static final String QUEUE_AVENGERS = "queue_avengers";
    public static final String QUEUE_MY_NHAN_NGU = "queue_my_nhan_ngu";
    public static final String QUEUE_VQV = "queue_vqv";
    public static final String QUEUE_REPORT = "queue_report";
    public static final String QUEUE_NU_DIEP_VIEN = "queue_nu_diep_vien";
    public static final String QUEUE_VIPPOINT_EVENT = "queue_vippoint_event";
    public static final String QUEUE_LOGIN_INFO = "queue_login_info";
    public static final String QUEUE_LOG_NO_HU = "queue_log_nohu";
    public static final String QUEUE_USER_MISSION = "queue_user_mission";
    public static final String QUEUE_EXCHANGE_MONEY = "queue_exchange_money";
    public static final String QUEUE_GIFT_CODE = "queue_gift_code";
    public static final String QUEUE_COMMISSION = "queue_commission";
    public static final String DEFAULT_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT_DATE = "dd-MM-yyyy";
    public static final String DEFAULT_FORMAT_DATE_TIME_MINUTES = "yyyyMMddHHmm";
    public static final String DEFAULT_FORMAT_DATE_TIME_MARKETING = "yyyy-MM-dd";
    public static final String ACTIVE = "1";
    public static final String INACTIVE = "0";
    public static final String SECRET_KEY = "@VinPlay#6102$817";
    public static final String LUCKY79 = "lucky79";
    public static final short SESSION_TIMEOUT_MINUTES = 180;
    public static final short SOCIAL_ACCESS_TOKEN_TIMEOUT_MINUTES = 1440;
    public static final short OTP_TIMEOUT_MINUTES = 5;
    public static final short SECURITY_TIMEOUT_MINUTES = 1440;
    public static final short EMAIL_TIMEOUT_MINUTES = 1440;
    public static final short RECHARGE_FAIL_TIMEOUT_MINUTES = 60;
    public static final String CASH_OUT_BY_CARD = "CashOutByCard";
    public static final String CASH_OUT_BY_TOPUP = "CashOutByTopUp";
    public static final String CASH_OUT_BY_BANK = "CashOutByBank";
    public static final String RECHARGE_BY_CARD = "RechargeByCard";
    public static final String RECHARGE_BY_VIN_CARD = "RechargeByVinCard";
    public static final String RECHARGE_BY_MEGA_CARD = "RechargeByMegaCard";
    public static final String RECHARGE_BY_IAP = "RechargeByIAP";
    public static final String RECHARGE_BY_BANK = "RechargeByBank";
    public static final String RECHARGE_BY_SMS = "RechargeBySMS";
    public static final String ACTION_NAME_TOPUP_VTCPAY = "TopupVTCPay";
    public static final String SAFE_MONEY = "SafeMoney";
    public static final String TRANSFER_MONEY = "TransferMoney";
    public static final String VIN2XU = "NapXu";
    public static final String ADMIN = "Admin";
    public static final String GIFT_CODE = "GiftCode";
    public static final String GIFT_CODE_VH = "GiftCodeVH";
    public static final String GIFT_CODE_MKT = "GiftCodeMKT";
    public static final String CASH_OUT_BY_VIPPOINT = "CashoutByVP";
    public static final String BOT = "Bot";
    public static final String REFUND_FEE = "RefundFee";
    public static final String CHARGE_SMS = "ChargeSMS";
    public static final String EVENT_VP = "EventVP";
    public static final String EVENT_VP_BONUS = "EventVPBonus";
    public static final String GC_AGENT = "GcAgent";
    public static final String GC_AGENT_EXPORT = "GcAgentExport";
    public static final String GC_AGENT_IMPORT = "GcAgentImport";
    public static final String BONUS_TOP_DS = "BonusTopDS";
    public static final String PKT_TICKET = "PktTicket";
    public static final String ACTION_NAME_NHIEM_VU = "NhiemVu";
    public static final String SERVICE_NAME_TOPUP_VTCPAY = "N\u00e1\u00ba\u00a1p vin qua VTCPay";
    public static final String VQMM = "VQMM";
    public static final String VQVIP = "VQVIP";
    public static final String TAI_XIU = "TaiXiu";
    public static final String BAU_CUA = "BauCua";
    public static final String MINI_POKER = "MiniPoker";
    public static final String CAO_THAP = "CaoThap";
    public static final String POKE_GO = "PokeGo";
    public static final String KHO_BAU = "KhoBau";
    public static final String NU_DIEP_VIEN = "NuDiepVien";
    public static final String SIEU_ANH_HUNG = "SieuAnhHung";
    public static final String VUONG_QUOC_VIN = "VuongQuocVin";
    public static final String KHO_BAU_VQ_FREE = "KhoBauVqFree";
    public static final String NU_DIEP_VIEN_VQ_FREE = "NuDiepVienVqFree";
    public static final String SIEU_ANH_HUNG_VQ_FREE = "SieuAnhHungVqFree";
    public static final String VUONG_QUOC_VIN_VQ_FREE = "VuongQuocVinVqFree";
    public static final String SAM = "Sam";
    public static final String BA_CAY = "BaCay";
    public static final String BINH = "Binh";
    public static final String TLMN = "Tlmn";
    public static final String TALA = "TaLa";
    public static final String LIENG = "Lieng";
    public static final String XI_TO = "XiTo";
    public static final String BAI_CAO = "BaiCao";
    public static final String POKER = "Poker";
    public static final String POKER_TOUR = "PokerTour";
    public static final String XOC_DIA = "XocDia";
    public static final String XI_DZACH = "XiDzach";
    public static final String CARO = "Caro";
    public static final String CO_TUONG = "CoTuong";
    public static final String CO_VUA = "CoVua";
    public static final String CO_UP = "CoUp";
    public static final String HAM_CA_MAP = "HamCaMap";
    public static final List<String> TIEU_VIN = Arrays.asList("CashOutByCard", "CashOutByTopUp", "Admin", "TransferMoney", "NapXu", "ChargeSMS", "GcAgent", "GcAgentExport");
    public static final List<String> NAP_VIN = Arrays.asList("RechargeByCard", "RechargeByVinCard", "RechargeByMegaCard", "RechargeByBank", "RechargeByIAP", "RechargeBySMS", "TransferMoney", "GiftCode", "CashoutByVP", "VQMM", "Admin", "VQVIP", "RefundFee", "EventVPBonus", "BonusTopDS", "GiftCodeMKT", "GiftCodeVH", "KhoBauVqFree", "NuDiepVienVqFree", "SieuAnhHungVqFree", "VuongQuocVinVqFree", "EventVP", "TopupVTCPay");
    public static final List<String> NAP_XU = Arrays.asList("NapXu", "VQMM", "Admin", "GiftCode", "GiftCodeVH", "GiftCodeMKT");
    public static final List<String> GAMES = Arrays.asList("TaiXiu", "TaiXiuMD5", "BauCua", "MiniPoker", "CaoThap", "PokeGo", "KhoBau", "NuDiepVien", "SieuAnhHung", "VuongQuocVin", "Sam", "BaCay", "Binh", "Tlmn", "TaLa", "Lieng", "XiTo", "BaiCao", "Poker", "PokerTour", "XocDia", "XiDzach", "Caro", "CoTuong", "CoVua", "CoUp", "HamCaMap");
    public static final List<String> NO_GAME = Arrays.asList("NhiemVu", "CashOutByCard", "CashOutByTopUp", "RechargeByCard", "RechargeByVinCard", "RechargeByMegaCard", "RechargeByIAP", "RechargeByBank", "RechargeBySMS", "TransferMoney", "NapXu", "Admin", "GiftCode", "GiftCodeVH", "GiftCodeMKT", "CashoutByVP", "Bot", "RefundFee", "ChargeSMS", "EventVPBonus", "GcAgent", "GcAgentExport", "GcAgentImport", "BonusTopDS", "KhoBauVqFree", "NuDiepVienVqFree", "SieuAnhHungVqFree", "VuongQuocVinVqFree", "SafeMoney", "EventVP", "TopupVTCPay");
    public static final List<String> VIN_IN_USER = Arrays.asList("RechargeByCard", "RechargeByVinCard", "RechargeByMegaCard", "RechargeByBank", "RechargeByIAP", "RechargeBySMS", "TopupVTCPay");
    public static final List<String> VIN_IN_EVENT = Arrays.asList("NhiemVu", "GiftCode", "GiftCodeMKT", "GiftCodeVH", "GcAgentImport", "RefundFee", "BonusTopDS", "CashoutByVP", "EventVPBonus", "EventVP", "VQMM", "VQVIP", "KhoBauVqFree", "NuDiepVienVqFree", "SieuAnhHungVqFree", "VuongQuocVinVqFree");
    public static final List<String> VIN_OUT_USER = Arrays.asList("CashOutByCard", "CashOutByTopUp");
    public static final List<String> VIN_OTHER = Arrays.asList("TransferMoney", "NapXu", "ChargeSMS", "Admin", "GcAgent", "GcAgentExport", "PktTicket");
    public static final int TRANSACTION_LOG_MONEY_IN_GAME = 1;
    public static final int TRANSACTION_LOG_MONEY_RECEIPT = 2;
    public static final int TRANSACTION_LOG_MONEY_SEND = 3;
    public static final long MONEY_REGISTER = 100000000L;
    public static final String SAM_LOG = "sam_log";
    public static final String TIEN_LEN_LOG = "tien_len_log";
    public static final int PAGE_SIZE = 10;
    public static final String FACEBOOK = "fb";
    public static final String GOOGLE = "gg";
    public static final int VIPPOINT_INDEX = 5000000;
    public static final String OTP_SMS = "0";
    public static final String OTP_APP = "1";
    public static final String POT_SYSTEM = "Vinplay";
    public static final long SLOT_FREE_WIN_MAX = 50000L;
    public static final int MAX_TRANSACTION_CACHE = 65;
    public static final long TRANSACTION_CACHE_TTL_HOURS = 72L;
    public static final String C = null;
    public static final String CACHE_BAN_CHAT = "cacheBanChat";
    public static final String COUNT_REQUEST_PORTAL_LOGGER = "count_request_portal_logger";
    public static final String TONG = "Tong";
    public static final String VIETTEL = "Viettel";
    public static final String VINAPHONE = "Vinaphone";
    public static final String MOBIFONE = "Mobifone";
    public static final String VNM = "VietNamMobile";
    public static final String BEELINE = "BeeLine";
    public static final String GATE = "Gate";
    public static final String ZING = "Zing";
    public static final String VCOIN = "Vcoin";
    public static final String SFONE = "SFone";
    public static final String GMOBILE = "GMobile";
    public static final String GARENA = "Garena";
    public static final String VINPLAY = "vinplay";
    public static final String WEB = "web";
    public static final String ANDROID = "ad";
    public static final String IOS = "ios";
    public static final String WINPHONE = "wp";
    public static final String FACEBOOK_APP = "fb";
    public static final String DESKTOP = "dt";
    public static final String OTHER = "ot";
    public static final int MONEY_20M = 20000000;
    public static final int MONEY_10M = 10000000;
    public static final int MONEY_9M = 9000000;
    public static final int MONEY_5M = 5000000;
    public static final int MONEY_3M = 3000000;
    public static final int MONEY_2M = 2000000;
    public static final int MONEY_1M = 1000000;
    public static final int MONEY_500K = 500000;
    public static final int MONEY_300K = 300000;
    public static final int MONEY_200K = 200000;
    public static final int MONEY_100K = 100000;
    public static final int MONEY_50K = 50000;
    public static final int MONEY_30K = 30000;
    public static final int MONEY_20K = 20000;
    public static final int MONEY_15K = 15000;
    public static final int MONEY_10K = 10000;
    public static final int MONEY_5K = 5000;
    public static final int MONEY_4K = 4000;
    public static final int MONEY_3K = 3000;
    public static final int MONEY_2K = 2000;
    public static final int MONEY_1K = 1000;
    public static final String SYSTEM = "system";
    public static final String DVT = "dvt";
    public static final String MAXPAY = "maxpay";
    public static final String _1PAY = "1pay";
    public static final String VTC = "vtc";
    public static final String EPAY = "epay";
    public static final String MEGA_CARD = "MegaCard";
    public static final String MEGA_CARD_VAT = "MegaCard_VAT";
    public static final String DAI_LY_VIN = "DaiLyVin";
    public static final String MARKETING_VIN = "MarketingVin";
    public static final String VAN_HANH_VIN = "VanHanhVin";
    public static final String DAI_LY_XU = "DaiLyXu";
    public static final String MARKETING_XU = "MarketingXu";
    public static final String VAN_HANH_XU = "VanHanhXu";
    public static final int FREEZE_MONEY = 0;
    public static final int NOT_FREEZE_MONEY = 1;
    public static final int UNLOCKED_FREEZE_MONEY = 2;
    public static final String SUCCESS_NGAN_LUONG_TRANS = "00";
    public static final int TOP_DS_FREEZE_MONEY = 0;
    public static final int TOP_DS_UNLOCKED_FREEZE_MONEY = 1;
    public static final int SCANNED = 0;
    public static final int NOT_SCANNED = 1;
    public static final int LOCKED = 1;
    public static final int NOT_LOCK = 0;
    public static final String TRANFER_MONEY_AGENT = "FreezeMoneyTranferAgent";
    public static final String MONEY_VIN = "vin";
    public static final String VIETTEL_VINPLAY = "vtt";
    public static final String VINAPHONE_VINPLAY = "vnp";
    public static final String MOBIFONE_VINPLAY = "vms";
    public static final String VIETNAMOBILE_VINPLAY = "vnm";
    public static final String BEELINE_VINPLAY = "bee";
    public static final String GATE_VINPLAY = "gate";
    public static final String ZING_VINPLAY = "zing";
    public static final String VCOIN_VINPLAY = "vcoin";
    public static final String SFONE_VINPLAY = "sfone";
    public static final String GMOBILE_VINPLAY = "gtel";
    public static final String GARENA_VINPLAY = "garena";
    public static final String ALL = "all";
    public static final String DVT_ALERT = "SOS! Canh bao he thong dichvuthe dang bi mat ket noi!";
    public static final String DVT_TIME_OUT = "SOS! Canh bao ket noi den dichvuthe bi timeout qua 5 lan lien tiep!";
    public static final String DVT_PENDING_VIETTEL = "[CANH BAO] He thong DVT tra ve pending qua 5 lan lien tiep Viettel!";
    public static final String DVT_PENDING_VINA = "[CANH BAO] He thong DVT tra ve pending qua 5 lan lien tiep Vinaphone!";
    public static final String DVT_PENDING_MOBI = "[CANH BAO] He thong DVT tra ve pending qua 5 lan lien tiep Mobifone!";
    public static final String DVT_PENDING_GATE = "[CANH BAO] He thong DVT tra ve pending qua 5 lan lien tiep FPT Gate!";
    public static final String _1PAY_ALERT = "SOS! Canh bao he thong 1Pay dang bi mat ket noi!";
    public static final String _1PAY_TIME_OUT = "SOS! Canh bao ket noi den 1Pay bi timeout qua 5 lan lien tiep!";
    public static final String _1PAY_OUT_OF_MONEY = "[CANH BAO] So du tai khoan Vinplay tai 1Pay dang het tien!";
    public static final String VTC_ALERT = "SOS! Canh bao he thong VTC dang bi mat ket noi!";
    public static final String VTC_RECHARGE_ALERT = "SOS! Canh bao he thong gach the vcoin VTC dang bi mat ket noi!";
    public static final String VTC_PENDING_VCOIN = "[CANH BAO] He thong VTC tra ve pending qua 5 lan lien tiep Vcoin!";
    public static final String VTC_TIME_OUT = "SOS! Canh bao ket noi den VTC bi timeout qua 5 lan lien tiep!";
    public static final String VTC_OUT_OF_MONEY = "[CANH BAO] So du tai khoan Vinplay tai VTC dang het tien!";
    public static final String EPAY_ALERT = "SOS! Canh bao he thong ePay dang bi mat ket noi!";
    public static final String EPAY_TIME_OUT = "SOS! Canh bao ket noi den ePay bi timeout qua 5 lan lien tiep!";
    public static final String EPAY_OUT_OF_MONEY = "[CANH BAO] So du tai khoan Vinplay tai 1Pay dang het tien!";
    public static final String EPAY_MEGA_ALERT = "SOS! Canh bao he thong MegaCard dang bi mat ket noi!";
    public static final String EPAY_MEGA_PENDING = "[CANH BAO] He thong MegaCard tra ve pending qua 5 lan lien tiep!";
    public static final String MAXPAY_ALERT = "SOS! Canh bao he thong Maxpay dang bi mat ket noi!";
    public static final String MAXPAY_PENDING_VIETTEL = "[CANH BAO] He thong Maxpay tra ve pending qua 5 lan lien tiep Viettel!";
    public static final String MAXPAY_PENDING_VINA = "[CANH BAO] He thong Maxpay tra ve pending qua 5 lan lien tiep Vinaphone!";
    public static final String MAXPAY_PENDING_MOBI = "[CANH BAO] He thong Maxpay tra ve pending qua 5 lan lien tiep Mobifone!";
    public static final String MAXPAY_PENDING_GATE = "[CANH BAO] He thong Maxpay tra ve pending qua 5 lan lien tiep FPT Gate!";
    public static final String LUCKY79_ALERT = "SOS! Canh bao he thong nap the ozze dang bi mat ket noi!";
    public static final String LUCKY79_PENDING_VIETTEL = "[CANH BAO] He thong nap the ozze tra ve pending qua 5 lan lien tiep Viettel!";
    public static final String LUCKY79_PENDING_VINA = "[CANH BAO] He thong nap the ozze tra ve pending qua 5 lan lien tiep Vinaphone!";
    public static final String LUCKY79_PENDING_MOBI = "[CANH BAO] He thong nap the ozze tra ve pending qua 5 lan lien tiep Mobifone!";
    public static final String LUCKY79_PENDING_GATE = "[CANH BAO] He thong nap the ozze tra ve pending qua 5 lan lien tiep FPT Gate!";
    public static final String ALL_PARTNER_RECHARGE_ALERT = "SOS! Canh bao tat ca cac partner gach the dang bi mat ket noi!";
    public static final String ALL_PARTNER_RECHARGE_VCOIN_ALERT = "SOS! Canh bao tat ca cac partner gach the Vcoin dang bi mat ket noi!";
    public static final String ALL_PARTNER_CASHOUT_BY_CARD_ALERT = "SOS! Canh bao tat ca cac partner mua the dang bi mat ket noi!";
    public static final String ALL_PARTNER_CASHOUT_BY_TOPUP_ALERT = "SOS! Canh bao tat ca cac partner topup dang bi mat ket noi!";
    public static final String PRE_PAID = "1";
    public static final String POST_PAID = "2";
    public static final String VIETTEL_NUMBER = "^(096|097|098|0162|0163|0164|0165|0166|0167|0168|0169|086|082)[\\d]{7}$";
    public static final String MOBIFONE_NUMBER = "^(090|093|0120|0121|0122|0126|0128|089)[\\d]{7}$";
    public static final String VINAPHONE_NUMBER = "^(091|094|0123|0124|0125|0127|0129|088)[\\d]{7}$";
    public static final String VIETNAMOBILE_NUMBER = "^(092|0188|0186)[\\d]{7}$";
    public static final String GMOBILE_NUMBER = "^(099|0199)[\\d]{7}$";
    public static final int CARD_NEW = 0;
    public static final int CARD_USED = 1;
    public static final String CARD_NEW_MESSAGE = "Th\u00e1\u00ba\u00bb ch\u00c6\u00b0a s\u00e1\u00bb\u00ad d\u00e1\u00bb\u00a5ng";
    public static final String CARD_USED_MESSAGE = "Th\u00e1\u00ba\u00bb \u00c4\u2018\u00c3\u00a3 s\u00e1\u00bb\u00ad d\u00e1\u00bb\u00a5ng";
    public static final String AUTHORIZATION = "Authorization";
    public static final String KEY_BASE_AUTHEN = "fU3z7wP0IeFOPntKXcRifUDTGbV8AXyI";
    public static final String SERVICE_NAME_NHIEM_VU = "Th\u00c6\u00b0\u00e1\u00bb\u0178ng Nhi\u00e1\u00bb\u2021m V\u00e1\u00bb\u00a5";
    public static final int RATIO_FEE_VIN = 2;
    public static final int RATIO_FEE_XU = 7;
    public static final String TOP_RUT_LOC = "TopRutLoc";
    public static final String TOP_TAN_LOC = "TopTanLoc";
    public static final String TOP_DS_AGENTS_1 = "TopDSAgents1";
    public static final int PASS_CONDITION_REWARD = 0;
    public static final int NOT_PASS_CONDITION_REWARD = 1;
    public static final int COMPLETE_ALL_LEVEL = 0;
    public static final int NOT_COMPLETE_ALL_LEVEL = 1;
    public static final int RATIO_NAP_VINPLAY_CARD = 10500;
    public static final int TIMEOUT_ALERT = 1;
    public static final int MEGA_VAT = 1;
    public static final int MEGA_NOT_VAT = 0;
    public static final String USER_MEGA_VAT = "VINPLAY";
    public static final String USER_MEGA_NOT_VAT = "CTT_VINPLAY";
    public static final String GIFTCODE_ACTIVE = "A";
    public static final String GIFTCODE_INACTIVE = "I";
    public static final String GIFTCODE_LOCK = "L";
    public static final String GIFTCODE_USED = "U";
    public static final int DONE = 1;
    public static final int INIT = 0;
}

