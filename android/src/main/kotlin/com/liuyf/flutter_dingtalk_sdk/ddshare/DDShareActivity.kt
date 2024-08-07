package com.liuyf.flutter_dingtalk_sdk.ddshare

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
import com.android.dingtalk.share.ddsharemodule.message.BaseReq
import com.android.dingtalk.share.ddsharemodule.message.BaseResp
import com.liuyf.flutter_dingtalk_sdk.handlers.IDDShareApiHandler
import com.liuyf.flutter_dingtalk_sdk.handlers.IDDShareResponseHandler
import java.lang.Exception

open class DDShareActivity :Activity(), IDDAPIEventHandler{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            IDDShareApiHandler.iddShareApi?.handleIntent(intent,this)
        }catch (e: Exception){
            e.printStackTrace()
            Log.d("lzc", "e===========>$e")
        }
        finish()
    }

    override fun onResp(p0: BaseResp?) {
//        TODO("Not yet implemented")
        if (p0 != null) {
            IDDShareResponseHandler.handleResponse(p0)
        }
    }

    override fun onReq(p0: BaseReq?) {
//        TODO("Not yet implemented")
    }
}