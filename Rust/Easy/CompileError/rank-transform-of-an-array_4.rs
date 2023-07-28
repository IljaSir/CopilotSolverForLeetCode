impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut sorted = arr.clone();
        sorted.sort_unstable();
        let mut rank = 1;
        let mut ranks = HashMap::new();
        for i in 0..arr.len() {
            if !ranks.contains_key(&sorted[i]) {
                ranks.insert(sorted[i], rank);
                rank += 1;
            }
        }
        arr.iter().map(|x| *ranks.get(x).unwrap()).collect()
    }
}