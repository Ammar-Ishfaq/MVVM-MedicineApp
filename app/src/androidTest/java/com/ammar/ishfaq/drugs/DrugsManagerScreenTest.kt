package com.ammar.ishfaq.drugs

import EnhancedTopAppBar
import LoginScreen
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ammar.ishfaq.drugs.models.drugs.AssociatedDrug
import com.ammar.ishfaq.drugs.ui.home.DrugCard
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DrugsManagerScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun screenContent_Login_calls() = runTest {
        var isLoggedIn = false


        composeTestRule.setContent {
            LoginScreen { isLoggedIn = true }
        }

        composeTestRule.onNodeWithTag("login").performTouchInput {
            swipeDown()
        }

        assertTrue(isLoggedIn)
    }

    @Test
    fun screenContent_Refresh_calls() = runTest {
        var onRefreshCalled = false


        composeTestRule.setContent {
            EnhancedTopAppBar { onRefreshCalled = true }
        }

        composeTestRule.onNodeWithTag("refresh").performTouchInput {
            swipeDown()
        }

        assertTrue(onRefreshCalled)
    }

    @Test
    fun screenContent_DrugDialog_calls() = runTest {
        var isDialogOpen = false


        composeTestRule.setContent {
            DrugCard(AssociatedDrug("daily", "asprin", "500 mg")) { isDialogOpen = true }
        }

        composeTestRule.onNodeWithTag("drug_item").performTouchInput {
            swipeDown()
        }

        assertTrue(isDialogOpen)
    }


}
