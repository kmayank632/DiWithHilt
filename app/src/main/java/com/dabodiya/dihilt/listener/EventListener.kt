package com.dabodiya.dihilt.listener

import androidx.lifecycle.MutableLiveData
import com.dabodiya.dihilt.base.BaseModel
import javax.inject.Inject


class EventListener @Inject constructor(
    private val resourceProvider: ResourceProvider
) {

    private val showHideToolBarLD = MutableLiveData<BaseModel>()

    /**
     * Notify to Update Tool Bar Visibility Status
     * */
    fun showToolBar(show: BaseModel) {
        showHideToolBarLD.postValue(show)
    }

    /**
     * @return Tool Bar Visibility Live Data
     * */
    fun getToolBarVisibilityLD() = showHideToolBarLD

}