impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let mut map = std::collections::BTreeMap::new();
        for i in 0..arr.len() {
            map.entry(arr[i]).or_insert_with(Vec::new).push(i);
        }
        let mut rank = 1;
        for (_, mut v) in map {
            v.sort();
            for i in v {
                arr[i] = rank;
            }
            rank += 1;
        }
        arr
    }
}