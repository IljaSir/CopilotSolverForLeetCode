impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut rank = 1;
        let mut last = arr[0];
        let mut map = HashMap::new();
        for i in 0..arr.len() {
            if arr[i] != last {
                last = arr[i];
                rank += 1;
            }
            map.entry(arr[i]).or_insert(rank);
        }
        arr.iter().map(|x| *map.get(x).unwrap() as i32).collect()
    }
}