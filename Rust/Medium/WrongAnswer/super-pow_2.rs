impl Solution {
    pub fn super_pow(a: i32, b: Vec<i32>) -> i32 {
        

        let mut v = 1;
        let mut a = a;
        for i in b.iter().rev() {
            v = v * (a.pow(*i as u32) % 1337) % 1337;
            a = a.pow(10) % 1337;
        }
        v
    }
}