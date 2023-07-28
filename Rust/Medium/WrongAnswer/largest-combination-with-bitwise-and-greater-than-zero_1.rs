impl Solution {
    pub fn largest_combination(candidates: Vec<i32>) -> i32 {
        
        let mut candidates = candidates;
        candidates.sort();
        candidates.reverse();
        let mut result = 0;
        let mut i = 0;
        while i < candidates.len() {
            let mut j = i + 1;
            while j < candidates.len() {
                let temp = candidates[i] & candidates[j];
                if temp > result {
                    result = temp;
                }
                j += 1;
            }
            i += 1;
        }
        result
    }
}