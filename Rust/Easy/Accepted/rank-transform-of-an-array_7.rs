impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut sorted: Vec<i32> = arr.clone();
        sorted.sort_unstable();
        let mut ranks: Vec<i32> = vec![];
        let mut rank = 1;
        for i in 0..sorted.len() {
            if i == 0 || sorted[i] != sorted[i - 1] {
                ranks.push(rank);
                rank += 1;
            } else {
                ranks.push(ranks[ranks.len() - 1]);
            }
        }
        arr.iter()
            .map(|&x| {
                let index = sorted.binary_search(&x).unwrap();
                ranks[index]
            })
            .collect()
    }
}