package guda.red.biz.taobao;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by foodoon on 2014/12/21.
 */
@Service("taobaoService")
public class TaobaoSerivce {

    public static final Logger log = LoggerFactory.getLogger(TaobaoSerivce.class);
    @Autowired
    private TaobaoAPIConfig taobaoAPIConfig;


    public TradesSoldGetResponse queryTradeSold(String sessionKey,Date startTime,Date endTime,long pageNo,long pageSize){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        TradesSoldGetRequest req=new TradesSoldGetRequest();
        req.setFields("buyer_nick,receiver_mobile,receiver_address,receiver_city,total_fee");
        req.setStartCreated(startTime);
        req.setEndCreated(endTime);

        req.setPageNo(pageNo);
        req.setPageSize(pageSize);
        req.setUseHasNext(true);
        try {
            return client.execute(req , sessionKey);
        } catch (ApiException e) {
            log.error("",e);
        }
        return null;
    }

    /**
     *
     * @param sessionKey
     * @param startTime end>start 跨度不能大于1天
     * @param endTime
     * @return
     */
    public TradesSoldIncrementvGetResponse queryIncrement(String sessionKey,Date startTime,Date endTime){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        TradesSoldIncrementvGetRequest req=new TradesSoldIncrementvGetRequest();
        req.setFields("seller_nick,buyer_nick,title,type,created,tid, seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,pic_path,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,alipay_id,alipay_no,is_lgtype");
        req.setStartCreate(startTime);
        req.setEndCreate(endTime);
        req.setPageNo(1L);
        req.setPageSize(100L);
        req.setUseHasNext(true);
        try {
            return client.execute(req , sessionKey);
        } catch (ApiException e) {
            log.error("",e);
        }
        return null;
    }

    public ItemsOnsaleGetResponse queryOnsaleItem(String sessionKey,Date startTime,Date endTime){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        ItemsOnsaleGetRequest req=new ItemsOnsaleGetRequest();
        req.setFields("approve_status,num_iid,title,nick,type,cid,pic_url,num,props,valid_thru,list_time,price,has_discount,has_invoice,has_warranty,has_showcase,modified,delist_time,postage_id,seller_cids,outer_id");
        req.setPageSize(100L);
        req.setStartModified(startTime);
        req.setEndModified(endTime);
        req.setIsCspu(true);
        try {
            return client.execute(req , sessionKey);
        } catch (ApiException e) {
            log.error("", e);
        }
        return null;
    }

    public ShopGetResponse queryShop(){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        ShopGetRequest req=new ShopGetRequest();
        req.setFields("sid,cid,title,nick,desc,bulletin,shop_score,created,modified");
        try {
            return client.execute(req);
        } catch (ApiException e) {
            log.error("", e);
        }
        return null;
    }

    public UserSellerGetResponse querySellerInfo(String sessionKey){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        UserSellerGetRequest req=new UserSellerGetRequest();
        req.setFields("user_id,nick,sex,seller_credit,type,has_more_pic,item_img_num,item_img_size,prop_img_num,prop_img_size,auto_repost,promoted_type,status,alipay_bind,consumer_protection,avatar,liangpin,sign_food_seller_promise,has_shop,is_lightning_consignment,has_sub_stock,is_golden_seller,vip_info,magazine_subscribe,vertical_market,online_gaming");
        try {
            return client.execute(req , sessionKey);
        } catch (ApiException e) {
            log.error("", e);
        }
        return null;
    }


    public ShopcatsListGetResponse queryShopCat(String sessionKey){
        TaobaoClient client=new DefaultTaobaoClient(taobaoAPIConfig.getApiUrl(), taobaoAPIConfig.getAppKey(), taobaoAPIConfig.getAppSecret());
        ShopcatsListGetRequest req=new ShopcatsListGetRequest();
        req.setFields("cid,parent_cid,name,is_parent");
        try {
            return client.execute(req);
        } catch (ApiException e) {
            log.error("", e);
        }
        return null;
    }
}
