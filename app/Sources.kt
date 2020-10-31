
import com.google.gson.annotations.SerializedName

data class Sources(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)