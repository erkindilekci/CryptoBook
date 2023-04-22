package com.erkindilekci.cryptobook.presentation.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.erkindilekci.cryptobook.presentation.coin_detail.components.CoinTag
import com.erkindilekci.cryptobook.presentation.coin_detail.components.TeamListItem
import com.erkindilekci.cryptobook.presentation.ui.theme.MyBlack
import com.erkindilekci.cryptobook.presentation.ui.theme.TextWhite
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MyBlack)
    ) {
        state.coin?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            fontSize = 24.sp,
                            modifier = Modifier.weight(8f),
                            color = TextWhite
                        )

                        Text(text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    
                    Text(text = coin.description, style = MaterialTheme.typography.body2, color = TextWhite)

                    Spacer(modifier = Modifier.height(15.dp))
                    
                    Text(text = "Tags", fontSize = 24.sp,color = TextWhite)

                    Spacer(modifier = Modifier.height(15.dp))
                    
                    FlowRow(mainAxisSpacing = 10.dp, crossAxisSpacing = 10.dp, modifier = Modifier.fillMaxWidth()) {
                        coin.tags.forEach { 
                            CoinTag(tag = it)
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Team Members", fontSize = 24.sp, color = TextWhite)

                    Spacer(modifier = Modifier.height(15.dp))
                }
                
                items(coin.team) {
                    TeamListItem(
                        teamMember = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider(thickness = 1.dp, color = Color.DarkGray, modifier = Modifier.padding(top = 6.dp, bottom = 6.dp))
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = TextWhite)
        }
    }
}