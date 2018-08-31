package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		System.out.println(joinPoint.getSignature().getDeclaringTypeName());
		String signatureString = joinPoint.getSignature().getName();		
		System.out.println(signatureString + " 시작");
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();		
		try {
			//new Object[] {new String("dooly")}
			//타겟의 메서드 호출
			/* 하던 작업을 마저 하도록 기다리는 메서드 */
			//proceed를 호출하지 않으면, 메서드를 수행을 반환하지 않는다. 잘못되면 크게 잘못 됨...
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
