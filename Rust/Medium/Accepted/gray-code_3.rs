impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut result = vec![0];
        for i in 0..n {
            let size = result.len();
            for j in (0..size).rev() {
                result.push(result[j] | 1 << i);
            }
        }
        result
    }
}