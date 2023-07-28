impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        Solution::find_combination(k, n, 1, &mut Vec::new(), &mut result);
        result
    }

    fn find_combination(k: i32, n: i32, start: i32, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if n < 0 {
            return;
        }

        if k == 0 {
            if n == 0 {
                result.push(path.clone());
            }
            return;
        }

        for i in start..=9 {
            path.push(i);
            Solution::find_combination(k - 1, n - i, i + 1, path, result);
            path.pop();
        }
    }
}