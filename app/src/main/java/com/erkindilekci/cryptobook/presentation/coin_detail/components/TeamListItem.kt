package com.erkindilekci.cryptobook.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.cryptobook.data.remote.dto.TeamMember
import com.erkindilekci.cryptobook.presentation.ui.theme.TextWhite

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        Text(text = teamMember.name, fontSize = 18.sp, color = TextWhite)

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = teamMember.position,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = TextWhite
        )
    }
}
