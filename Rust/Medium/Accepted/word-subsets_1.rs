impl Solution {
    pub fn word_subsets(words1: Vec<String>, words2: Vec<String>) -> Vec<String> {
        
        let mut words2 = words2;
        let mut words2_count = vec![0; 26];
        for word in words2.iter() {
            let mut count = vec![0; 26];
            for c in word.chars() {
                count[c as usize - 'a' as usize] += 1;
            }
            for i in 0..26 {
                words2_count[i] = words2_count[i].max(count[i]);
            }
        }
        let mut result = vec![];
        for word in words1.iter() {
            let mut count = vec![0; 26];
            for c in word.chars() {
                count[c as usize - 'a' as usize] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if words2_count[i] > count[i] {
                    ok = false;
                    break;
                }
            }
            if ok {
                result.push(word.clone());
            }
        }
        result
    }
}