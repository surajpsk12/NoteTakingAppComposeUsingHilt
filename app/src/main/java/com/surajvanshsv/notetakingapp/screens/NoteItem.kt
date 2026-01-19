package com.surajvanshsv.notetakingapp.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.notetakingapp.room.Note
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NoteItem(note: Note) {
    // Create a gradient based on note id for variety
    val gradientColors = listOf(
        listOf(Color(0xFF667eea), Color(0xFF764ba2)),
        listOf(Color(0xFFf093fb), Color(0xFFF5576C)),
        listOf(Color(0xFF4facfe), Color(0xFF00f2fe)),
        listOf(Color(0xFFfa709a), Color(0xFFfee140)),
        listOf(Color(0xFF30cfd0), Color(0xFF330867)),
        listOf(Color(0xFFa8edea), Color(0xFFfed6e3))
    )

    val selectedGradient = gradientColors[note.id % gradientColors.size]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column {
            // Gradient accent bar at top
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .background(
                        Brush.horizontalGradient(selectedGradient)
                    )
            )

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                // Title with decorative dot
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Circle,
                        contentDescription = null,
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape),
                        tint = selectedGradient[0]
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = note.title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            letterSpacing = (-0.5).sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Content
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        letterSpacing = 0.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Timestamp
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = formatTimestamp(note.timestamp),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.5.sp
                        ),
                        color = selectedGradient[0].copy(alpha = 0.8f)
                    )
                }
            }
        }
    }
}

private fun formatTimestamp(timestamp: Long): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy • HH:mm", Locale.getDefault())
    return sdf.format(Date(timestamp))
}