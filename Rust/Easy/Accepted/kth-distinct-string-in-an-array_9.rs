impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        arr.iter().filter(|s| arr.iter().filter(|t| s == t).count() == 1).nth((k-1) as usize).map(|s| s.clone()).unwrap_or("".to_string())
    }
}