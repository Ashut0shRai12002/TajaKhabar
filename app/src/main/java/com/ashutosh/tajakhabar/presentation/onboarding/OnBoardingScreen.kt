package com.ashutosh.tajakhabar.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.packFloats
import com.ashutosh.tajakhabar.presentation.common.NewsButton
import com.ashutosh.tajakhabar.presentation.common.NewsTextButton
import com.ashutosh.tajakhabar.presentation.common.PageIndicator
import com.ashutosh.tajakhabar.presentation.onboarding.components.Dimens
import com.ashutosh.tajakhabar.presentation.onboarding.components.OnBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier){

    Column(modifier = modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "GetStarted")
                    else -> listOf("", "")
                }
            }

        }
        HorizontalPager(state = pagerState) { index ->
            OnBoarding(page = pages[index])
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(Dimens.MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PageIndicator(
                pageSize = pages.size,
                modifier = Modifier.width(Dimens.PageIndicatorWidth),
                selectedPage = pagerState.currentPage
            )


            val scope = rememberCoroutineScope()
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(text = buttonState.value[0], onclick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    })
                }
                NewsButton(
                    text = buttonState.value[1],
                    onclick = {
                        scope.launch {
                            if (pagerState.currentPage == 3) {
                                //TODO
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }

        }
    }
}