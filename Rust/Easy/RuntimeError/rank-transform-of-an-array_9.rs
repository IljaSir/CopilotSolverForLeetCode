impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let mut rank = vec![0; 100001];
        for i in 0..arr.len() {
            rank[arr[i] as usize] = i as i32 + 1;
        }
        let mut j = 0;
        for i in 1..rank.len() {
            if rank[i] != 0 {
                rank[i] = j + 1;
                j += 1;
            }
        }
        for i in 0..arr.len() {
            arr[i] = rank[arr[i] as usize];
        }
        arr
    }
}