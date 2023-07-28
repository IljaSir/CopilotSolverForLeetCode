impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut result: Vec<String> = vec![];
        let mut s: Vec<i32> = vec![];
        let mut i = 0;
        for x in 1..=n {
            s.push(x);
            result.push(String::from("Push"));
            if s[i] != target[i] {
                s.pop();
                result.push(String::from("Pop"));
            } else {
                i += 1;
                if i == target.len() {
                    break;
                }
            }
        }
        result
    }
}