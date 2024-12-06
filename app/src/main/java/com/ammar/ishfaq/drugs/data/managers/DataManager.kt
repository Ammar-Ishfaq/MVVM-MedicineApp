package com.ammar.ishfaq.drugs.data.managers

import com.ammar.ishfaq.drugs.data.ApiInterface
import com.ammar.ishfaq.drugs.prefs.PreferencesHelper
import com.ammar.ishfaq.drugs.prefs.PreferencesHelperImpl
import com.ammar.ishfaq.drugs.utility.ResourceProvider

interface DataManager {
    fun getApiHelper(): ApiInterface
    fun getResourceManager(): ResourceProvider
    fun getPreferencesHelper(): PreferencesHelper
    fun getPreferencesHelperImpl(): PreferencesHelperImpl

}