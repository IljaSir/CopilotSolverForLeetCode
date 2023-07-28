impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut arr = vec![a, b, c];
        arr.sort();
        let (a, b, c) = (arr[0], arr[1], arr[2]);
        if a + b <= c {
            a + b
        } else {
            (a + b + c) / 2
        }
    }
}