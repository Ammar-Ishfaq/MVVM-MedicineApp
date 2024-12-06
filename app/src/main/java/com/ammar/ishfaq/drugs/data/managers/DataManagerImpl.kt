package com.ammar.ishfaq.drugs.data.managers

import com.ammar.ishfaq.drugs.data.ApiInterface
import com.ammar.ishfaq.drugs.prefs.PreferencesHelper
import com.ammar.ishfaq.drugs.prefs.PreferencesHelperImpl
import com.ammar.ishfaq.drugs.utility.ResourceProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val appService: ApiInterface,
    private val preferencesHelper: PreferencesHelper,
    private val preferencesHelperImpl: PreferencesHelperImpl
) : DataManager {

    override fun getResourceManager(): ResourceProvider {
        return resourceProvider
    }

    override fun getApiHelper(): ApiInterface {
        return appService
    }

    override fun getPreferencesHelper(): PreferencesHelper {
        return preferencesHelper
    }

    override fun getPreferencesHelperImpl(): PreferencesHelperImpl {
        return preferencesHelperImpl
    }

}