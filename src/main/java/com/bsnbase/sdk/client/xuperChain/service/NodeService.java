package com.bsnbase.sdk.client.xuperChain.service;

import com.bsnbase.sdk.entity.base.BaseReqModel;
import com.bsnbase.sdk.entity.base.BaseResModel;
import com.bsnbase.sdk.entity.config.Config;
import com.bsnbase.sdk.entity.req.xuperChain.*;
import com.bsnbase.sdk.entity.res.xuperChain.ResGetBlockInformation;
import com.bsnbase.sdk.entity.res.xuperChain.ResGetTransaction;
import com.bsnbase.sdk.entity.res.xuperChain.ResKeyEscrow;
import com.bsnbase.sdk.entity.res.xuperChain.ResKeyEscrowNo;
import com.bsnbase.sdk.util.common.HttpService;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class NodeService {

    /**
     * 密钥托管模式下调用智能合约接口
     *
     * @param kes
     * @return
     * @throws IOException
     */
    public static ResKeyEscrow reqChainCode(@NotNull ReqKeyEscrow kes) throws IOException {
        String api = Config.config.getApi() + "/api/xuperchain/v1/node/reqChainCode";
        BaseReqModel<ReqKeyEscrow> req = new BaseReqModel<ReqKeyEscrow>(kes);
        req.setReqHeader(Config.config.getUserCode(),Config.config.getAppCode());
        HttpService<ReqKeyEscrow, ResKeyEscrow> httpService = new HttpService<ReqKeyEscrow, ResKeyEscrow>();
        BaseResModel<ResKeyEscrow> res = httpService.post(req, api, ResKeyEscrow.class);
        return res.getBody();

    }


    /**
     * 公钥上传模式下调用智能合约接口
     *
     * @param kes
     * @return
     * @throws IOException
     */
    public static ResKeyEscrowNo nodeTrans(@NotNull ReqTrans kes) throws IOException {
        String api = Config.config.getApi() + "/api/xuperchain/v1/node/trans";
        BaseReqModel<ReqTrans> req = new BaseReqModel<>(kes);
        req.setReqHeader(Config.config.getUserCode(),Config.config.getAppCode());
        HttpService<ReqTrans, ResKeyEscrowNo> httpService = new HttpService<>();
        BaseResModel<ResKeyEscrowNo> res = httpService.post(req, api, ResKeyEscrowNo.class);
        return res.getBody();

    }

    /**
     * 获取交易信息
     *
     * @param reqData
     */
    public static ResGetTransaction getTxInfoByTxHash(ReqGetTransaction reqData) {
        String api = Config.config.getApi() + "/api/xuperchain/v1/node/getTxInfoByTxHash";
        BaseReqModel<ReqGetTransaction> req = new BaseReqModel<ReqGetTransaction>(reqData);
        req.setReqHeader(Config.config.getUserCode(),Config.config.getAppCode());
        HttpService<ReqGetTransaction, ResGetTransaction> httpService = new HttpService<ReqGetTransaction, ResGetTransaction>();
        BaseResModel<ResGetTransaction> res = httpService.post(req, api, ResGetTransaction.class);

        return res.getBody();
    }

    /**
     * 获取块信息
     *
     * @param reqData
     */
    public static ResGetBlockInformation getBlockInfo(ReqGetBlockInformation reqData) {
        String api = Config.config.getApi() + "/api/xuperchain/v1/node/getBlockInfo";
        BaseReqModel<ReqGetBlockInformation> req = new BaseReqModel<ReqGetBlockInformation>(reqData);
        req.setReqHeader(Config.config.getUserCode(),Config.config.getAppCode());
        HttpService<ReqGetBlockInformation, ResGetBlockInformation> httpService = new HttpService<ReqGetBlockInformation, ResGetBlockInformation>();
        BaseResModel<ResGetBlockInformation> res = httpService.post(req, api, ResGetBlockInformation.class);
        return res.getBody();
    }

}
