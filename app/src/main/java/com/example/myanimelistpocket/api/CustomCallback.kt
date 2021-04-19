package com.example.myanimelistpocket.api

interface CustomCallback {
    fun onSucess(message: String?, retData: Any?)
    fun onFailure(message: String?)
}