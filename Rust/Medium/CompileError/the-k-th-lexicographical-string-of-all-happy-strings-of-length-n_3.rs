impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res: Vec<String> = vec!["a".to_string(), "b".to_string(), "c".to_string()];
        for i in 1..n {
            let mut tmp = vec![];
            for s in res {
                if s.ends_with('a') {
                    tmp.push(s.clone() + "b");
                    tmp.push(s + "c");
                } else if s.ends_with('b') {
                    tmp.push(s.clone() + "a");
                    tmp.push(s + "c");
                } else {
                    tmp.push(s.clone() + "a");
                    tmp.push(s + "b");
                }
            }
            res = tmp;);
            k = 1;
        }
        res
    }
}