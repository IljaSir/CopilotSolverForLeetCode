impl Solution {
    pub fn find_the_distance_value(arr1: Vec<i32>, arr2: Vec<i32>, d: i32) -> i32 {
        
        let mut count = 0;
        for i in arr1 {
            let mut ok = true;
            for j in &arr2 {
                if (i - j).abs() <= d {
                    ok = false;
                    break;
                }
            }
            if ok {
                count += 1;
            }
        }
        count
    }
}