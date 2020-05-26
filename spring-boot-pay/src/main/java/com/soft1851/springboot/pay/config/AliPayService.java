package com.soft1851.springboot.pay.config;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.soft1851.springboot.pay.domain.AlipayVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AliPayService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
@Service
public class AliPayService {
    Logger logger = LoggerFactory.getLogger("AliPayService.class");


    @Autowired
    AlipayVo staticVo;

    //    支付服务
    public String aliPay(Integer amount) throws AlipayApiException {

        // 构建支付数据信息
        Map<String, String> data = new HashMap<>();
        data.put("subject", staticVo.getSubject()); //订单标题
        data.put("out_trade_no", new SimpleDateFormat().format(new Date())); //商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复      //此处模拟订单号为时间
        data.put("timeout_express", staticVo.getTimout_express()); //该笔订单允许的最晚付款时间
        data.put("total_amount", amount.toString()); //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        data.put("product_code", "FAST_INSTANT_TRADE_PAY"); //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY


        //构建客户端
        DefaultAlipayClient alipayRsa2Client = new DefaultAlipayClient(
                AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();// APP支付
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 网页支付
//        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();  //移动h5
        request.setNotifyUrl(AliPayConfig.notify_url);
        request.setReturnUrl(AliPayConfig.return_url);
        request.setBizContent(JSON.toJSONString(data));
        logger.info(JSON.toJSONString(data));
        String response = alipayRsa2Client.pageExecute(request).getBody();
        logger.info(response);
        return response;
    }
}