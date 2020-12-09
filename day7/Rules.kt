import java.util.regex.Pattern

class Rules(lines: List<String>) {
    private val initPattern = Pattern.compile("(?<color>.+) bags contain (?<content>.+)\\.")
    private val contentPattern = Pattern.compile("(?<numberOfBags>(\\d+)) (?<colorOfBags>.+) bag.*")
    private val content: HashMap<String, List<InnerBags>> = HashMap()

    init {
        for (line in lines) {
            setContent(line)
        }
    }

    private fun setContent(line: String) {
        val matcher = initPattern.matcher(line)
        matcher.find()
        val color = matcher.group("color")
        val content = matcher.group("content")
        val relations = ArrayList<InnerBags>()
        if (content != "no other bags") {
            val bagContent = content.split(",")
            for (oneBagInBag in bagContent) {
                val contentMatcher = contentPattern.matcher(oneBagInBag)
                contentMatcher.find()
                val colorOfBags = contentMatcher.group("colorOfBags")
                val numberOfBags = contentMatcher.group("numberOfBags").toInt()
                relations.add(InnerBags(numberOfBags, colorOfBags))
            }
        }
        this.content[color] = relations
    }

    fun countPath(bagColor: String): Int {
        val set = HashSet<String>()
        innerCountPath(bagColor, set)
        return set.size
    }

    private fun innerCountPath(bagColor: String, set: HashSet<String>) {
        for (contentEntry in content) {
            for (innerEntry in contentEntry.value) {
                if (innerEntry.color == bagColor) {
                    set.add(contentEntry.key)
                    innerCountPath(contentEntry.key, set)
                }
            }
        }
    }

    fun countInnerBags(bagColor: String): Int {
        val contentForColor = content[bagColor]
        return if (contentForColor?.isEmpty()!!) {
            1
        } else {
            return contentForColor.sumBy { it.number * countInnerBags(it.color) } + 1
        }
    }

}