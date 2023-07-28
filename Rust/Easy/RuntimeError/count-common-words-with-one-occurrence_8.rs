impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut words1 = words1;
        let mut words2 = words2;
        words1.sort();
        words2.sort();
        let mut i = 0;
        let mut j = 0;
        while i < words1.len() && j < words2.len() {
            if words1[i] == words2[j] {
                let mut count1 = 0;
                let mut count2 = 0;
                while i < words1.len() && words1[i] == words1[i + count1] {
                    count1 += 1;
                }
                while j < words2.len() && words2[j] == words2[j + count2] {
                    count2 += 1;
                }
                if count1 == 1 && count2 == 1 {
                    count += 1;
                }
                i += count1;
                j += count2;
            } else if words1[i] < words2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        count
    }
}