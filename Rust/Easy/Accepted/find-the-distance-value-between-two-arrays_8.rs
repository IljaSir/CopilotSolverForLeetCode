impl Solution {
    pub fn find_the_distance_value(arr1: Vec<i32>, arr2: Vec<i32>, d: i32) -> i32 {
        
        let mut count = 0;
        for a in arr1 {
            if arr2.iter().all(|&b| (a - b).abs() > d) {
                count += 1;
            }
        }
        count
    }
}