
import com.google.gson.annotations.SerializedName

data class SourcesX(
    val articles: List<ArticleX>,
    val status: String,
    val totalResults: Int
)