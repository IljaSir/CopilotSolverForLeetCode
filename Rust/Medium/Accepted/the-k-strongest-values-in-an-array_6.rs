impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort();
        let n = arr.len();
        let m = arr[(n-1)/2];
        arr.sort_by_key(|&x| (-(i32::abs(x - m)), -x));
        arr[0..k as usize].to_vec()
    }
}