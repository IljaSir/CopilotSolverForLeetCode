impl Solution {
    pub fn mirror_reflection(p: i32, q: i32) -> i32 {
        
        let mut p = p;
        let mut q = q;
        while p % 2 == 0 && q % 2 == 0 {
            p /= 2;
            q /= 2;
        }
        if p % 2 == 1 && q % 2 == 1 {
            1
        } else if p % 2 == 1 && q % 2 == 0 {
            0
        } else {
            2
        }
    }
}