impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut words_frequency: Vec<i32> = Vec::new();
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            word.sort();
            let mut count = 1;
            for i in 1..word.len() {
                if word[i] == word[i-1] {
                    count += 1;
                } else {
                    break;
                }
            }
            words_frequency.push(count);
        }
        let mut queries_frequency: Vec<i32> = Vec::new();
        for query in queries {
            let mut query = query.chars().collect::<Vec<char>>();
            query.sort();
            let mut count = 1;
            for i in 1..query.len() {
                if query[i] == query[i-1] {
                    count += 1;
                } else {
                    break;
                }
            }
            queries_frequency.push(count);
        }
        let mut ans: Vec<i32> = Vec::new();
        for query in queries_frequency {
            let mut count = 0;
            for word in &words_frequency {
                if query < *word {
                    count += 1;
                }
            }
            ans.push(count);
        }
        ans
    }
}