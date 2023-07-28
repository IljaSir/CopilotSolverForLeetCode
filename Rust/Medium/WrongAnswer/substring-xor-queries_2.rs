impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut prefix_xor = vec![0; s.len() + 1];
        let mut result = vec![];
        for (i, c) in s.chars().enumerate() {
            prefix_xor[i + 1] = prefix_xor[i] ^ (c as i32 - '0' as i32);
        }
        for q in queries {
            let (left, right) = (q[0], q[1]);
            let mut i = 0;
            for (j, &x) in prefix_xor.iter().enumerate() {
                if x ^ left == right {
                    i = j;
                    break;
                }
            }
            if i == 0 {
                result.push(vec![-1, -1]);
            } else {
                result.push(vec![i as i32 - 1, i as i32]);
            }
        }
        result
    }
}