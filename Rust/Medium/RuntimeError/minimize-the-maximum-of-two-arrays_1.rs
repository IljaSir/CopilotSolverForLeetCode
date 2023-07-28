impl Solution {
    pub fn minimize_set(divisor1: i32, divisor2: i32, unique_cnt1: i32, unique_cnt2: i32) -> i32 {
        
        let mut div1 = divisor1;
        let mut div2 = divisor2;
        let mut cnt1 = unique_cnt1;
        let mut cnt2 = unique_cnt2;
        while div1 != div2 {
            if div1 < div2 {
                let tmp = div1;
                div1 = div2;
                div2 = tmp;
                let tmp = cnt1;
                cnt1 = cnt2;
                cnt2 = tmp;
            }
            let tmp = div1;
            div1 = div2;
            div2 = tmp % div2;
        }
        let mut res = cnt1 + cnt2;
        if cnt1 % div1 != 0 {
            res -= div1 - cnt1 % div1;
        }
        res
    }
}