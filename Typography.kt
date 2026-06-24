package ui.theme

import androidx.compose.ui.graphics.Color // КРИТИЧЕСКИ ВАЖНО: без этого Color не заработает
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

object AppTypography {
    val screenTitle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold,
        // Подставил OnSurfaceLight (темный), так как TextPrimary у тебя нет
        color = OnSurfaceLight
    )

    val screenSubtitle = TextStyle(
        fontSize = 14.sp,
        // Подставил SecondaryLight (спокойный синий/серый) вместо TextSecondary
        color = SecondaryLight,
        textAlign = TextAlign.Center
    )

    val buttonLabel = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        // Белый текст на кнопке
        color = OnPrimaryLight
    )

    val errorText = TextStyle(
        fontSize = 12.sp,
        color = ErrorLight, // Используем твой ErrorLight
        fontWeight = FontWeight.Medium
    )

    val linkText = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        // Основной акцентный цвет для ссылок
        color = PrimaryLight
    )
}