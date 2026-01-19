package com.surajvanshsv.notetakingapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.surajvanshsv.notetakingapp.room.Note
import com.surajvanshsv.notetakingapp.viewmodel.NoteViewModel

@Composable
fun NoteScreen(viewModel: NoteViewModel = hiltViewModel()) {

    val notes: List<Note> by viewModel.allNotes.collectAsState(emptyList())

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Section with gradient
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF667eea),
                                Color(0xFF764ba2)
                            )
                        )
                    )
                    .padding(top = 48.dp, bottom = 32.dp, start = 24.dp, end = 24.dp)
            ) {
                Column {
                    Text(
                        text = "My Notes",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 36.sp,
                            letterSpacing = (-1).sp
                        ),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${notes.size} note${if (notes.size != 1) "s" else ""} saved",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.5.sp
                        ),
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }

            // Input Card Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(
                        text = "Create New Note",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Title Input
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = {
                            Text(
                                "Title",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Title,
                                contentDescription = null,
                                tint = Color(0xFF667eea)
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF667eea),
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                            focusedLabelColor = Color(0xFF667eea),
                            cursorColor = Color(0xFF667eea)
                        ),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Content Input
                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        label = {
                            Text(
                                "Note Description",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Description,
                                contentDescription = null,
                                tint = Color(0xFF764ba2)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF764ba2),
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                            focusedLabelColor = Color(0xFF764ba2),
                            cursorColor = Color(0xFF764ba2)
                        ),
                        textStyle = MaterialTheme.typography.bodyLarge,
                        maxLines = 5
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Add Button with gradient
                    Button(
                        onClick = {
                            if (title.isNotBlank() && content.isNotBlank()) {
                                viewModel.insert(
                                    Note(0, title, content, System.currentTimeMillis())
                                )
                                title = ""
                                content = ""
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        enabled = title.isNotBlank() && content.isNotBlank()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    if (title.isNotBlank() && content.isNotBlank()) {
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                Color(0xFF667eea),
                                                Color(0xFF764ba2)
                                            )
                                        )
                                    } else {
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                Color.Gray.copy(alpha = 0.3f),
                                                Color.Gray.copy(alpha = 0.3f)
                                            )
                                        )
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Add Note",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.5.sp
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Notes List
            AnimatedVisibility(
                visible = notes.isNotEmpty(),
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Recent Notes",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    LazyColumn(
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        items(notes.reversed()) { note ->
                            NoteItem(note)
                        }
                    }
                }
            }

            // Empty State
            AnimatedVisibility(
                visible = notes.isEmpty(),
                enter = fadeIn(animationSpec = tween(500)),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "📝",
                            style = MaterialTheme.typography.displayLarge.copy(
                                fontSize = 72.sp
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "No notes yet",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Create your first note above",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}