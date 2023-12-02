package com.example.taskt.ui.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.taskt.ui.theme.Blue900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTodoScreen() {
    var text by remember { mutableStateOf("") }
    var isDatePickerSelected by remember { mutableStateOf(false) }
    var isTimePickerSelected by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "cancel", color = Color(0xFFC70039))
            Text(text = "done", color = Color(0xFF0096FF))
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "I need to...") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .height(100.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.DarkGray,
                disabledTextColor = Color.Transparent,
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Column(
            modifier = Modifier.weight(weight = 0.5f).background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { isDatePickerSelected = !isDatePickerSelected }) {
                        Icon(
                            Icons.Rounded.DateRange,
                            contentDescription = "date picker icon",
                            tint = if (isDatePickerSelected) Blue900 else Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    IconButton(onClick = { isTimePickerSelected = !isTimePickerSelected }) {
                        Icon(
                            Icons.Rounded.AccessTime,
                            contentDescription = "time pick icon",
                            tint = if (isTimePickerSelected) Blue900 else Color.LightGray
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Inbox", color = Blue900)
                    Spacer(modifier = Modifier.width(3.dp))
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(Color(android.graphics.Color.parseColor("#0000FF")))
                    )
                }
            }
        }
    }
}