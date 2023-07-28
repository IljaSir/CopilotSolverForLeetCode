impl Solution {
    pub fn find_the_distance_value(arr1: Vec<i32>, arr2: Vec<i32>, d: i32) -> i32 {
        
        let mut result = 0;
        for i in 0..arr1.len() {
            let mut flag = true;
            for j in 0..arr2.len() {
                if (arr1[i] - arr2[j]).abs() <= d {
                    flag = false;
                    break;
                }
            }
            if flag {
                result += 1;
            }
        }
        result
    }
}