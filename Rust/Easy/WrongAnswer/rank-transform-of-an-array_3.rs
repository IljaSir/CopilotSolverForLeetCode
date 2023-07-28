impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let mut arr2 = arr.clone();
        arr.sort_unstable();
        arr2.sort_unstable();
        arr2.dedup();
        for i in 0..arr.len() {
            arr[i] = arr2.binary_search(&arr[i]).unwrap() as i32 + 1;
        }
        arr
    }
}