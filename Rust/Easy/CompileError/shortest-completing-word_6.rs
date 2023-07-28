impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut license_plate = license_plate
            .to_lowercase()
            .chars()
            .filter(|c| c.is_alphabetic())
            .collect::<Vec<char>>();
        license_plate.sort();
        let mut words = words
            .iter()
            .map(|s| s.chars().collect::<Vec<char>>())
            .collect::<Vec<Vec<char>>>();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        for word in words {
            let mut word = word;
            word.sort();
            let mut i = 0;
            for c in word {
                if i >= license_plate.len() {
                    return word.into_iter().collect::<String>();
                }
                if c == license_plate[i] {
                    i += 1;
                }
            }
            if i == license_plate.len() {
                return word.into_iter().collect::<String>();
            }
        }
        String::from("")
    }
}