impl Solution {
    pub fn sort_by_bits(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort_by_key(|n| (n.count_ones(), *n));
        arr
    }
}