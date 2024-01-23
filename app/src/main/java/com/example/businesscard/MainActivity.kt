package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardData(getDefaultPerson())
                }
            }
        }
    }
}

data class Person(
    val name: String,
    val title: String,
    val company: String,
    val phone: String,
    val email: String,
    val socialMedia: String
)

fun getDefaultPerson(): Person {
    return Person(
        name = "Rahmat Suregar",
        title = "Newbie Kotlin Enthusiast",
        company = "Google Android",
        phone = "123-456-7890",
        email = "android@example.com",
        socialMedia = "@android"
    )
}


@Composable
fun CardData(person: Person, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.avatar)

    Box(
        modifier = Modifier
            .background(color = Color(0xFF86A789))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,

    ) {
        Column(
            modifier = modifier.padding(top = 120.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
//
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Image(painter = image, contentDescription = "Profile Picture")
            }

            Text(
                text = person.name,
                fontSize = 40.sp,
                lineHeight = 40.sp,
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
            )

            Text(
                text = person.title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color.White,
            )
    }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp)
                .align(alignment = Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactItem(Icons.Default.Phone, person.phone, "Phone")
            ContactItem(Icons.Default.Share, person.socialMedia, "LinkedIn")
            ContactItem(Icons.Default.Email, person.email, "Email")
        }
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String, label: String? = null) {
    Row(
        modifier = Modifier
            .width(250.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(42.dp)
                .padding(8.dp),
            tint = Color.White,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = label ?: text, fontSize = 12.sp, color = Color.White)
            Text(text = text, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        CardData(getDefaultPerson())
    }
}