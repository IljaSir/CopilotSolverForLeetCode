impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort();
        let median = arr[(arr.len() - 1) / 2];
        arr.sort_by_key(|&x| (-(i32::abs(x - median)), -x));
        arr.truncate(k as usize);
        arr
    }
}