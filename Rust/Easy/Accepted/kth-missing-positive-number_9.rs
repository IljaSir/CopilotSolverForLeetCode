impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut expect = 1;
        for num in arr {
            while expect < num {
                if k == 1 {
                    return expect;
                }
                expect += 1;
                k -= 1;
            }
            expect += 1;
        }
        while k > 0 {
            expect += 1;
            k -= 1;
        }
        expect - 1
    }
}