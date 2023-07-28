impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut result = vec![0];
        for i in 0..n {
            let mut tmp = result.clone();
            tmp.reverse();
            for j in 0..tmp.len() {
                tmp[j] += 1 << i;
            }
            result.append(&mut tmp);
        }
        result
    }
}