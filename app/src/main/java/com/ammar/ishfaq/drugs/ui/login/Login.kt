import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ammar.ishfaq.drugs.R

@Composable
fun LoginApp(onLoginSuccess: (String) -> Unit) {
    LoginScreen(onLogin = { enteredUsername ->
        onLoginSuccess.invoke(enteredUsername)
    })
}

@Composable
fun LoginScreen(onLogin: (String) -> Unit) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var rememberMe by remember { mutableStateOf(false) }
    var openGithub by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.app_icon),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                    )

                    Text(
                        text = "Welcome Back!",
                        style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it }
                        )
                        Text("Remember Me", style = MaterialTheme.typography.bodyLarge)
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            var userUname = username.text
                            if (userUname.isBlank()) {
                                userUname = "ammarishfaq25@gmail.com"
                            }
                            onLogin(userUname)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("login")
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Login", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }

        if (openGithub) OpenGitHubProfile("https://github.com/ammar-ishfaq") {
            openGithub = false
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Button(
                onClick = { openGithub = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Visit GitHub Profile ⎘",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun OpenGitHubProfile(url: String, onInvoke: () -> Unit) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
        onInvoke.invoke()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginApp {}
}
